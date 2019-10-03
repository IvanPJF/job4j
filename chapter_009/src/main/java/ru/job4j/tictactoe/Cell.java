package ru.job4j.tictactoe;

import java.util.Objects;

/**
 * Cell.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public class Cell implements ICell {

    private int x;
    private int y;
    private boolean isChoice;
    private String mark = " ";

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
    public ICell factoryCell(int x, int y) {
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

    /**
     * Get cell label.
     * @return
     */
    @Override
    public String getMark() {
        return this.mark;
    }

    /**
     * Set cell label.
     * @param mark
     */
    @Override
    public void setMark(String mark) {
        if (mark != null) {
            this.mark = mark.substring(0, 1);
        }
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
                && isChoice == cell.isChoice
                && Objects.equals(mark, cell.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isChoice, mark);
    }
}
