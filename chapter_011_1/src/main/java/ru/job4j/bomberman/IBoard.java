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
     * @throws InterruptedException
     */
    boolean move(Cell srcPos, Cell destPos) throws InterruptedException;

    /**
     * Blocks the first non-locked field cell.
     *
     * @return Blocked field cell.
     */
    Cell lockFreeCell();
}
