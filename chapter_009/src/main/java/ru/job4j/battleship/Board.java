package ru.job4j.battleship;

import java.util.*;

/**
 * Board.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public class Board implements IBoard {

    private final Set<ICell> cells = new TreeSet<>();
    private final List<IShip> ships = new ArrayList<>();
    private final Set<ICell> area = new TreeSet<>();

    public Board(int size, ICell cell) {
        fillBoard(size, cell);
    }

    /**
     * Fill the Board with the provided type of cells according to the specified sizes.
     * @param size
     * @param cell
     */
    private void fillBoard(int size, ICell cell) {
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                cells.add(cell.factoryCells(x, y));
            }
        }
    }

    /**
     * Get a list of all ships on the Board.
     * @return A list of all the ships on the Board.
     */
    @Override
    public List<IShip> getShips() {
        return this.ships;
    }

    /**
     * Area near the ships.
     * @return A lot of cells you can't build ships on.
     */
    @Override
    public Set<ICell> getAreaShips() {
        return this.area;
    }

    /**
     * Get free cells.
     * @return Free cells on which to build ships.
     */
    @Override
    public Set<ICell> getFreeCells() {
        return Collections.unmodifiableSet(cells);
    }

    /**
     * Add a ship to the Board.
     * The ship is built from left to right or from bottom to top.
     * @param ship
     * @param horizontal The location of the ship-horizontal or vertical.
     * @param startX Start of X-axis ship construction.
     * @param startY Start of Y-axis ship construction.
     * @return A logical result of the construction of the ship.
     */
    @Override
    public boolean addShip(IShip ship, boolean horizontal, int startX, int startY) {
        Set<ICell> location = new TreeSet<>();
        ICell lastAdd = null;
        for (ICell cell : this.cells) {
            if (lastAdd == null && cell.getX() == startX && cell.getY() == startY
                    || lastAdd != null && horizontal && lastAdd.getX() + 1 == cell.getX() && lastAdd.getY() == cell.getY()
                    || lastAdd != null && !horizontal && lastAdd.getY() + 1 == cell.getY() && lastAdd.getX() == cell.getX()) {
                location.add(cell);
                lastAdd = cell;
            }
            if (ship.size() == location.size()) {
                break;
            }
        }
        boolean result = ship.isCorrect(location);
        if (result) {
            ship.setLocation(location);
            this.cells.removeAll(location);
            this.ships.add(ship);
            this.area.addAll(areaAroundShip(location));
        }
        return result;
    }

    /**
     * Determine the area around the ship.
     * @param locationShip Cells that occupies the ship.
     * @return Adjacent cells of the ship.
     */
    private Set<ICell> areaAroundShip(Set<ICell> locationShip) {
        Set<ICell> result = new TreeSet<>();
        for (ICell locCell : locationShip) {
            for (ICell brdCell : this.cells) {
                if ((brdCell.getY() - 1 == locCell.getY() || brdCell.getY() + 1 == locCell.getY() || brdCell.getY() == locCell.getY())
                        && (brdCell.getX() - 1 == locCell.getX() || brdCell.getX() + 1 == locCell.getX() || brdCell.getX() == locCell.getX())
                ) {
                    result.add(brdCell);
                }
            }
        }
        this.cells.removeAll(result);
        return result;
    }
}
