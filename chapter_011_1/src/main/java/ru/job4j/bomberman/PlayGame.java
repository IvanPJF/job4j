package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class for play game.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public class PlayGame {

    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final IBoard board;
    private final IHero bomber;
    private final IHero monster;
    private int countMonster;

    public PlayGame(IBoard board, IHero bomber, IHero monster) {
        this.board = board;
        this.bomber = bomber;
        this.monster = monster;
    }

    public void setCountMonsters(int volume) {
        this.countMonster = volume;
    }

    /**
     * Play game.
     */
    public void play() {
        runBomber();
        runMonsters();
    }

    private void runBomber() {
        this.pool.submit(() -> {
            this.bomber.setPosition(this.board.lockFreeCell());
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Cell newPosition = this.bomber.step(Way.LEFT);
                if (this.board.move(this.bomber.getPosition(), newPosition)) {
                    this.bomber.setPosition(newPosition);
                }
            }
        });
    }

    private void runMonsters() {
        for (int i = 0; i < this.countMonster; i++) {
            this.pool.submit(() -> {
                IHero monster = this.monster.createNewInstance();
                monster.setPosition(this.board.lockFreeCell(true));
                while (!Thread.currentThread().isInterrupted()) {
                    Cell newPosition = monster.step(Way.randomWay());
                    try {
                        if (this.board.move(monster.getPosition(), newPosition)) {
                            monster.setPosition(newPosition);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    public List<Cell> tryCreateWalls(List<Cell> coordinateWalls) {
        List<Cell> remains = new ArrayList<>();
        for (Cell cell : coordinateWalls) {
            if (!this.board.tryOccupy(cell)) {
                remains.add(cell);
            }
        }
        return remains;
    }

    /**
     * Stop game.
     */
    public void stop() {
        this.pool.shutdownNow();
        while (!this.pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
