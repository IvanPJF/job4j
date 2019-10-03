package ru.job4j.tictactoe;

import java.util.Set;

/**
 * Board interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public interface IBoard {

    /**
     * Makes a move at the given coordinates.
     *
     * @param x    Row number.
     * @param y    Column number.
     * @param mark Player label.
     * @return The logical result of the move: True - Successful move else - False.
     */
    boolean choiceCell(int x, int y, String mark);

    /**
     * Checks victory status.
     *
     * @return
     */
    boolean isWin();

    /**
     * Checks board fullness.
     *
     * @return
     */
    boolean isFilled();

    /**
     * Sets the length of the winning line.
     *
     * @param size
     * @return The logical result of the move.
     * True - If the size does not exceed the width of the board, else - False.
     */
    boolean setSizeWinLine(int size);

    /**
     * Get the set of all board cells.
     *
     * @return
     */
    Set<ICell> allCells();

    /**
     * Get last selected cell.
     *
     * @return
     */
    ICell lastCell();

    /**
     * Clear all board cells from all marks.
     */
    void clearBoard();
}
