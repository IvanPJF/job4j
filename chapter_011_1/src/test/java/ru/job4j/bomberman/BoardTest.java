package ru.job4j.bomberman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    @Test
    public void whenMoveIsValidThenTrue() throws InterruptedException {
        IBoard board = new Board(2, 2);
        Cell srcPos = board.lockFreeCell();
        Cell destPos = new Cell(1, 0);
        boolean result = board.move(srcPos, destPos);
        assertThat(result, is(true));
    }

    @Test
    public void whenMoveIsInvalidThenFalse() throws InterruptedException {
        IBoard board = new Board(2, 2);
        Cell srcPos = board.lockFreeCell();
        Cell destPosFirst = new Cell(20, 0);
        boolean result = board.move(srcPos, destPosFirst);
        assertThat(result, is(false));
    }

    @Test
    public void whenLockFreeCellThenCell00() {
        IBoard board = new Board(1, 1);
        Cell result = board.lockFreeCell();
        assertThat(result, is(new Cell(0, 0)));
    }

    @Test
    public void whenOtherThreadLockedLastFreeCellAndNotFreeCellsThenNull() throws InterruptedException {
        IBoard board = new Board(1, 1);
        Thread thread = new Thread(board::lockFreeCell);
        thread.start();
        thread.join();
        Cell result = board.lockFreeCell();
        assertThat(result, is((Cell) null));
    }

    @Test
    public void whenLockFreeCellInReverseOrderThenCell22() {
        IBoard board = new Board(3, 3);
        Cell result = board.lockFreeCell(true);
        assertThat(result, is(new Cell(2, 2)));
    }
}