package ru.job4j.bomberman;

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
    private final IBomber bomber;

    public PlayGame(IBoard board, IBomber bomber) {
        this.board = board;
        this.bomber = bomber;
    }

    /**
     * Play game.
     */
    public void play() {
        this.pool.submit(() -> {
            this.bomber.setPosition(this.board.lockFreeCell());
            while (!Thread.currentThread().isInterrupted()) {
                Cell newPosition = this.bomber.step();
                try {
                    if (this.board.move(this.bomber.getPosition(), newPosition)) {
                        this.bomber.setPosition(newPosition);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
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
