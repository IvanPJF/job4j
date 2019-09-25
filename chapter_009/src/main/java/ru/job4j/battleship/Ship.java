package ru.job4j.battleship;

import java.util.*;

/**
 * Ship.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public class Ship implements IShip {

    private final int size;
    private final Set<ICell> locationCells = new TreeSet<>();
    private boolean isKilled;

    public Ship(int size) {
        this.size = size;
    }

    /**
     * The size of the ship.
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Relation the ship to the cells.
     * @param locationCells Cells for binding to the ship.
     */
    @Override
    public void setLocation(Set<ICell> locationCells) {
        if (!isCorrect(locationCells)) {
            throw new RuntimeException("Incorrect layout of cells");
        }
        this.locationCells.clear();
        this.locationCells.addAll(locationCells);
    }

    /**
     * Get the cells that the ship occupies.
     * @return
     */
    @Override
    public Set<ICell> getLocationCells() {
        return Collections.unmodifiableSet(this.locationCells);
    }

    /**
     * Check the correctness of the provided cells.
     * @param locationCells Cells for binding to the ship.
     * @return
     */
    @Override
    public boolean isCorrect(Set<ICell> locationCells) {
        if (this.size != locationCells.size()) {
            throw new RuntimeException("Incorrect number of cells");
        }
        boolean result = true;
        Iterator<ICell> iterCells = new TreeSet<>(locationCells).iterator();
        if (iterCells.hasNext()) {
            ICell startCell = iterCells.next();
            boolean isHorizontal = isHorizontal(startCell, iterCells);
            while (iterCells.hasNext()) {
                ICell nextCell = iterCells.next();
                if (isHorizontal && startCell.getY() != nextCell.getY() && startCell.getX() == nextCell.getX()
                        || !isHorizontal && startCell.getY() == nextCell.getY() && startCell.getX() != nextCell.getX()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Checks if the ship is destroyed.
     * @return
     */
    @Override
    public boolean isKilled() {
        boolean result = true;
        if (!isKilled) {
            for (ICell cell : this.locationCells) {
                if (!cell.isChoice()) {
                    result = false;
                    break;
                }
            }
            isKilled = result;
        }
        return result;
    }

    /**
     * Checks the direction of the ship.
     * If the cell is one, then the arrangement is horizontal.
     * @param startCell The first cell of the ship.
     * @param iterCells Iterator with the next cell.
     * @return True when direction is horizontal else False.
     */
    private boolean isHorizontal(ICell startCell, Iterator<ICell> iterCells) {
        ICell nextCell = null;
        if (iterCells.hasNext()) {
            nextCell = iterCells.next();
        }
        return nextCell == null || startCell.getY() - nextCell.getY() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ship ship = (Ship) o;
        return size == ship.size
                && isKilled == ship.isKilled
                && locationCells.equals(ship.locationCells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, locationCells, isKilled);
    }
}
