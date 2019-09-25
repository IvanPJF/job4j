package ru.job4j.battleship;

import java.util.List;
import java.util.Set;

/**
 * Board interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public interface IBoard {

    /**
     * Add a ship to the Board.
     * The ship is built from left to right or from bottom to top.
     * @param ship
     * @param horizontal The location of the ship-horizontal or vertical.
     * @param startX Start of X-axis ship construction.
     * @param startY Start of Y-axis ship construction.
     * @return A logical result of the construction of the ship.
     */
    boolean addShip(IShip ship, boolean horizontal, int startX, int startY);

    /**
     * Get a list of all ships on the Board.
     * @return A list of all the ships on the Board.
     */
    List<IShip> getShips();

    /**
     * Area near the ships.
     * @return A lot of cells you can't build ships on.
     */
    Set<ICell> getAreaShips();

    /**
     * Get free cells.
     * @return Free cells on which to build ships.
     */
    Set<ICell> getFreeCells();
}
