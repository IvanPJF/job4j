package ru.job4j.battleship;

import java.util.Set;

/**
 * Ship interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public interface IShip {

    /**
     * Horizontal position of the ship.
     */
    boolean HORIZONTAL = true;

    /**
     * Vertical position of the ship.
     */
    boolean VERTICAL = false;

    /**
     * The size of the ship.
     * @return
     */
    int size();

    /**
     * Relation the ship to the cells.
     * @param locationCells Cells for binding to the ship.
     */
    void setLocation(Set<ICell> locationCells);

    /**
     * Get the cells that the ship occupies.
     * @return
     */
    Set<ICell> getLocationCells();

    /**
     * Check the correctness of the provided cells.
     * @param locationCells Cells for binding to the ship.
     * @return
     */
    boolean isCorrect(Set<ICell> locationCells);

    /**
     * Checks if the ship is destroyed.
     * @return
     */
    boolean isKilled();
}
