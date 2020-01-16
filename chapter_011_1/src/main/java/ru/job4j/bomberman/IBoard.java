package ru.job4j.bomberman;

/**
 * Board interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public interface IBoard {

    /**
     * Makes movement from source to destination.
     *
     * @param srcPos  Source position.
     * @param destPos Destination.
     * @return Return{true} - if the move is completed successfully, else {false}.
     */
    boolean move(Cell srcPos, Cell destPos);

    /**
     * Blocks the first non-locked field cell.
     *
     * @return Blocked field cell.
     */
    Cell lockFreeCell();

    Cell lockFreeCell(boolean isReverseOrderFind);

    boolean tryOccupy(Cell target);
}
