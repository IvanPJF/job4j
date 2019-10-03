package ru.job4j.tictactoe;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Board.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public class Board implements IBoard {

    private Set<ICell> cells = new TreeSet<>();
    private int sizeWinLine;
    private ICell lastCell;
    private int numberMoves;

    public Board(int size, ICell cell) {
        this.sizeWinLine = size;
        fillBoard(size, cell);
    }

    /**
     * Fill the Board with the provided type of cells according to the specified sizes.
     *
     * @param size
     * @param cell
     */
    private void fillBoard(int size, ICell cell) {
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                cells.add(cell.factoryCell(x, y));
            }
        }
    }

    /**
     * Clear all board cells from all marks.
     */
    @Override
    public void clearBoard() {
        for (ICell cell : this.cells) {
            cell.setMark(" ");
            cell.setChoice(false);
        }
        this.lastCell = null;
        this.numberMoves = 0;
    }

    /**
     * Get the set of all board cells.
     *
     * @return
     */
    @Override
    public Set<ICell> allCells() {
        return Collections.unmodifiableSet(this.cells);
    }

    /**
     * Get last selected cell.
     *
     * @return
     */
    @Override
    public ICell lastCell() {
        return this.lastCell;
    }

    /**
     * Makes a move at the given coordinates.
     *
     * @param x    Row number.
     * @param y    Column number.
     * @param mark Player label.
     * @return The logical result of the move: True - Successful move else - False.
     */
    @Override
    public boolean choiceCell(int x, int y, String mark) {
        boolean result = false;
        ICell findCell = new Cell(x, y);
        for (ICell cell : this.cells) {
            if (cell.equals(findCell)) {
                cell.setChoice(true);
                cell.setMark(mark);
                this.lastCell = cell;
                this.numberMoves++;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks victory status.
     * First winLine - Horizontal victory,
     * Second winLine - Vertical victory,
     * First winDiagonal - Left diagonal victory,
     * Second winDiagonal - Right diagonal victory
     *
     * @return
     */
    @Override
    public boolean isWin() {
        return this.numberMoves >= this.sizeWinLine
                && (winLine((cell, lastCheckCell) -> cell.getX() == lastCheckCell.getX())
                || winLine((cell, lastCheckCell) -> cell.getY() == lastCheckCell.getY())
                || winDiagonal(true, (y) -> y != this.sizeWinLine,
                (cell, lastCheckCell) -> cell.getY() == lastCheckCell.getY() - 1)
                || winDiagonal(false, (y) -> y != 1,
                (cell, lastCheckCell) -> cell.getY() == lastCheckCell.getY() + 1));
    }

    /**
     * Checks board fullness.
     *
     * @return
     */
    @Override
    public boolean isFilled() {
        return this.numberMoves >= this.cells.size();
    }

    /**
     * Checks the winning line.
     *
     * @param cellsBiPredicate Set the location condition - horizontally or vertically.
     * @return
     */
    private boolean winLine(BiPredicate<ICell, ICell> cellsBiPredicate) {
        boolean result = false;
        ICell lastCheckCell = this.lastCell;
        int sizeLine = 0;
        for (ICell cell : this.cells) {
            if (cellsBiPredicate.test(cell, lastCheckCell)) {
                if (cell.isChoice() && cell.getMark().equals(this.lastCell.getMark())) {
                    sizeLine++;
                } else {
                    sizeLine = 0;
                }
            }
            result = sizeLine == this.sizeWinLine;
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Checks the winning diagonal.
     *
     * @param left             True - left diagonal, False - right diagonal.
     * @param predicateY       Condition "Y" to search for the leftmost diagonal cell.
     * @param cellsBiPredicate The condition for comparing diagonal neighboring cells.
     * @return
     */
    private boolean winDiagonal(boolean left, Predicate<Integer> predicateY, BiPredicate<ICell, ICell> cellsBiPredicate) {
        boolean result = false;
        ICell lastCheckCell = getEmptyCopyFirstDiagonalCell(left, predicateY);
        int sizeLine = 0;
        for (ICell cell : this.cells) {
            if (cell.getX() == lastCheckCell.getX() && cell.getY() == lastCheckCell.getY()
                    || cell.getX() == lastCheckCell.getX() + 1 && cellsBiPredicate.test(cell, lastCheckCell)) {
                if (cell.isChoice() && cell.getMark().equals(this.lastCell.getMark())) {
                    sizeLine++;
                } else {
                    sizeLine = 0;
                }
                lastCheckCell = cell;
            }
            result = sizeLine == this.sizeWinLine;
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Get an empty copy of the first diagonal cell.
     *
     * @param left       True - left diagonal, False - right diagonal.
     * @param predicateY Condition "Y" to search for the leftmost diagonal cell.
     * @return
     */
    private ICell getEmptyCopyFirstDiagonalCell(boolean left, Predicate<Integer> predicateY) {
        int x = this.lastCell.getX();
        int y = this.lastCell.getY();
        while (x != 1 && predicateY.test(y)) {
            x--;
            y = left ? ++y : --y;
        }
        return this.lastCell.factoryCell(x, y);
    }

    /**
     * Sets the length of the winning line.
     *
     * @param size
     * @return The logical result of the move.
     * True - If the size does not exceed the width of the board, else - False.
     */
    @Override
    public boolean setSizeWinLine(int size) {
        boolean result = false;
        int maxSize = (int) Math.sqrt(this.cells.size());
        if (size < maxSize) {
            this.sizeWinLine = size;
            result = true;
        }
        return result;
    }
}
