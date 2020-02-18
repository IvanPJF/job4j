package ru.job4j.exam.lift;

import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Play lift.
 *
 * Launch parameters:
 * -c - number of floors
 * -h - floor height
 * -s - lift speed
 * -o - time between opening and closing doors
 *
 * Example: java Play -c 15 -h 3 -s 3 -o 5
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 29.01.2020
 */
public class Play {

    private final ExecutorService pool = Executors.newFixedThreadPool(2);
    private final BlockingDeque<Integer> dequeCalls = new LinkedBlockingDeque<>();
    private final ILift lift;
    private final IShow show;
    private final ParserArgs parser;

    public Play(ILift lift, IShow show, ParserArgs parser) {
        this.lift = lift;
        this.show = show;
        this.parser = parser;
    }

    public void play() {
        this.pool.submit(() -> {
            while (true) {
                int targetFloor = dequeCalls.takeFirst();
                lift.targetFloor(targetFloor);
                while (!lift.isFinish()) {
                    Thread.sleep(parser.getHeightFloor() / parser.getSpeedLift() * 1000);
                    show.msgRidesLift(lift.step());
                }
                show.msgOpenDoor();
                Thread.sleep(parser.getOpenDoorTime() * 1000);
                show.msgCloseDoor();
            }
        });
        this.pool.submit(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    show.msgQuestionDestFloor();
                    int targetFloor = scanner.nextInt();
                    scanner.nextLine();
                    if (lift.isFinish()) {
                        dequeCalls.putFirst(targetFloor);
                    } else {
                        dequeCalls.putLast(targetFloor);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        ParserArgs parserArgs = new ParserArgs(args);
        IShow show = new DefaultShow();
        ILift lift = new Lift(1);
        Play play = new Play(lift, show, parserArgs);
        play.play();
    }
}
