package ru.job4j.bomberman;

import java.util.Random;

/**
 * Class Pc BomberMan.
 * BomberMan automatically makes a move to any cell.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public class PcBomber extends BaseBomber {

    private final Random rnd = new Random();
    private final Way[] allWay = Way.values();
    private final Cell lastSuccessPos = initLastSuccessPosition();

    private Cell initLastSuccessPosition() {
        Cell cell = getPosition();
        return new Cell(cell.getX(), cell.getY());
    }

    /**
     * The choice of direction for the move.
     * Selects a random direction of travel.
     * The result of choosing the direction of the path is used in the method {@link #step}.
     *
     * @return
     */
    @Override
    public Way choiceWay() {
        if (!this.lastSuccessPos.equals(getPosition())) {
            Cell currPos = getPosition();
            this.lastSuccessPos.setX(currPos.getX());
            this.lastSuccessPos.setY(currPos.getY());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return this.allWay[this.rnd.nextInt(this.allWay.length)];
    }
}
