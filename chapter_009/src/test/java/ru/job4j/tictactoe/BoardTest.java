package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    @Test
    public void whenBoardSize2AndCellThenAllCellsSize4() {
        IBoard board = new Board(2, new Cell());
        int result = board.allCells().size();
        int expected = 4;
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize2AndCellAndChoiceFreeCell22ThenTrue() {
        IBoard board = new Board(2, new Cell());
        boolean result = board.choiceCell(2, 2, "X");
        assertThat(result, is(true));
    }

    @Test
    public void whenBoardSize2AndCellAndChoiceNotFreeCell22ThenFalse() {
        IBoard board = new Board(2, new Cell());
        board.choiceCell(2, 2, "X");
        boolean result = board.choiceCell(2, 2, "X");
        assertThat(result, is(false));
    }

    @Test
    public void whenWinVerticalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 1, mark);
        board.choiceCell(1, 2, mark);
        board.choiceCell(1, 3, mark);
        boolean result = board.isWin();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotWinVerticalThenReturnFalse() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 1, mark);
        board.choiceCell(1, 2, mark);
        boolean result = board.isWin();
        assertThat(result, is(false));
    }

    @Test
    public void whenWinHorizontalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 1, mark);
        board.choiceCell(2, 1, mark);
        board.choiceCell(3, 1, mark);
        boolean result = board.isWin();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotWinHorizontalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 1, mark);
        board.choiceCell(3, 1, mark);
        boolean result = board.isWin();
        assertThat(result, is(false));
    }

    @Test
    public void whenWinLeftDiagonalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 3, mark);
        board.choiceCell(2, 2, mark);
        board.choiceCell(3, 1, mark);
        boolean result = board.isWin();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotWinLeftDiagonalThenReturnFalse() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 3, mark);
        board.choiceCell(2, 2, mark);
        boolean result = board.isWin();
        assertThat(result, is(false));
    }

    @Test
    public void whenWinRightDiagonalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(1, 1, mark);
        board.choiceCell(2, 2, mark);
        board.choiceCell(3, 3, mark);
        boolean result = board.isWin();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotWinRightDiagonalThenReturnTrue() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.choiceCell(2, 2, mark);
        board.choiceCell(3, 3, mark);
        boolean result = board.isWin();
        assertThat(result, is(false));
    }

    @Test
    public void whenSetSizeWinLineIsSmallerSizeBoardThenTrue() {
        IBoard board = new Board(3, new Cell());
        boolean result = board.setSizeWinLine(2);
        assertThat(result, is(true));
    }

    @Test
    public void whenSetSizeWinLineIsLargerSizeBoardThenFalse() {
        IBoard board = new Board(3, new Cell());
        boolean result = board.setSizeWinLine(4);
        assertThat(result, is(false));
    }

    @Test
    public void whenSetSizeWinLineIs2ThenWinLineIn2Elements() {
        IBoard board = new Board(3, new Cell());
        String mark = "X";
        board.setSizeWinLine(2);
        board.choiceCell(2, 2, mark);
        board.choiceCell(3, 3, mark);
        boolean result = board.isWin();
        assertThat(result, is(true));
    }
}