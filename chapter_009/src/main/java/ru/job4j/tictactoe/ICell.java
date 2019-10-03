package ru.job4j.tictactoe;

/**
 * Cell interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 03.10.2019
 *@version 0.1
 */
public interface ICell extends Comparable<ICell> {

    /**
     * Factory method of creating cells.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return The cell created at the specified coordinates.
     */
    ICell factoryCell(int x, int y);

    /**
     * Get X-axis coordinate
     * @return
     */
    int getX();

    /**
     * Get Y-axis coordinate
     * @return
     */
    int getY();

    /**
     * Check if this cell has been selected.
     * @return
     */
    boolean isChoice();

    /**
     * To set the cell check status.
     * @param choice True when cell is checked else False.
     */
    void setChoice(boolean choice);

    /**
     * Get cell label.
     * @return
     */
    String getMark();

    /**
     * Set cell label.
     * @param mark
     */
    void setMark(String mark);
}
