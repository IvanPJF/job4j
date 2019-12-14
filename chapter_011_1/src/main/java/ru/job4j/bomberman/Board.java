package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class board.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public class Board implements IBoard {

    private final Lock[][] board;

    public Board(int sizeHoriz, int sizeVert) {
        this.board = new ReentrantLock[sizeHoriz][sizeVert];
        fillLocks();
    }

    /**
     * Fills an array of locks.
     */
    private void fillLocks() {
        for (int out = 0; out < this.board.length; out++) {
            for (int in = 0; in < this.board[out].length; in++) {
                this.board[out][in] = new ReentrantLock();
            }
        }
    }

    /**
     * Makes movement from source to destination.
     *
     * @param srcPos  Source position.
     * @param destPos Destination.
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean move(Cell srcPos, Cell destPos) throws InterruptedException {
        boolean isMove = false;
        int destX = destPos.getX();
        int destY = destPos.getY();
        if (isValidCoordinate(destX, destY)
                && this.board[destX][destY].tryLock(500, TimeUnit.MILLISECONDS)) {
            this.board[srcPos.getX()][srcPos.getY()].unlock();
            isMove = true;
        }
        return isMove;
    }

    /**
     * Checks the possibility of existing coordinates.
     *
     * @param destX X coordinate.
     * @param destY Y coordinate.
     * @return
     */
    private boolean isValidCoordinate(int destX, int destY) {
        return destX >= 0 && destY >= 0
                && destX < this.board.length && destY < this.board[destX].length;
    }

    /**
     * Blocks the first non-locked field cell.
     *
     * @return Blocked field cell.
     */
    @Override
    public Cell lockFreeCell() {
        for (int out = 0; out < this.board.length; out++) {
            for (int in = 0; in < this.board[out].length; in++) {
                try {
                    if (this.board[out][in].tryLock(500, TimeUnit.MILLISECONDS)) {
                        return new Cell(out, in);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return null;
    }
}
