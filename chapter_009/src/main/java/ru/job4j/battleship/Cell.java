package ru.job4j.battleship;

import java.util.Objects;

/**
 * Cell.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public class Cell implements ICell {

    private int x;
    private int y;
    private boolean isChoice;

    public Cell() {
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Factory method of creating cells.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return The cell created at the specified coordinates.
     */
    @Override
    public ICell factoryCells(int x, int y) {
        return new Cell(x, y);
    }

    /**
     * Get X-axis coordinate
     * @return
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Get Y-axis coordinate
     * @return
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Check if this cell has been selected.
     * @return
     */
    @Override
    public boolean isChoice() {
        return this.isChoice;
    }

    /**
     * To set the cell check status.
     * @param choice True when cell is checked else False.
     */
    @Override
    public void setChoice(boolean choice) {
        this.isChoice = choice;
    }

    @Override
    public int compareTo(ICell o) {
        int diffX = this.x - o.getX();
        int diffY = this.y - o.getY();
        return diffX == 0 ? diffY : diffX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x
                && y == cell.y
                && isChoice == cell.isChoice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isChoice);
    }
}
