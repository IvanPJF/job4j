package ru.job4j.battleship;

import java.util.List;
import java.util.Set;

/**
 * Run the game.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.09.2019
 *@version 0.1
 */
public class PlayGame {

    private final List<IShip> ships;
    private final Set<ICell> freeCells;
    private final Set<ICell> areaAroundShips;

    public PlayGame(IBoard board) {
        this.ships = board.getShips();
        this.freeCells = board.getFreeCells();
        this.areaAroundShips = board.getAreaShips();
    }

    /**
     * Shot with coordinates.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return The logical outcome shot being fired. True when hit/sunk otherwise False.
     */
    public boolean shot(int x, int y) {
        ICell shotCell = new Cell(x, y);
        boolean result = false;
        ICell missCell = findCell(this.freeCells, shotCell);
        missCell = missCell == null ? findCell(this.areaAroundShips, shotCell) : missCell;
        if (missCell == null) {
            for (IShip ship : this.ships) {
                if (!ship.isKilled()) {
                    ICell hit = findCell(ship.getLocationCells(), shotCell);
                    if (hit != null) {
                        hit.setChoice(true);
                        result = true;
                        break;
                    }
                }
            }
        } else {
            missCell.setChoice(true);
        }
        return result;
    }

    /**
     * Finding a cell in a set.
     * @param cells Search source.
     * @param findCell The cells we're looking for.
     * @return Null when the cell is not found, otherwise the found cell.
     */
    private ICell findCell(Set<ICell> cells, ICell findCell) {
        ICell result = null;
        for (ICell cell : cells) {
            if (cell.equals(findCell)) {
                result = cell;
                break;
            }
        }
        return result;
    }

    /**
     * Checks the possibility of winning.
     * @return True when all ships on the Board are sunk otherwise False.
     */
    public boolean isWin() {
        boolean result = true;
        for (IShip ship : this.ships) {
            if (!ship.isKilled()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
