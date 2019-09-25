package ru.job4j.battleship;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayGameTest {

    @Test
    public void when1AccurateShotThenTrue() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(2), IShip.HORIZONTAL, 1, 1);
        PlayGame play = new PlayGame(board);
        boolean result = play.shot(1, 1);
        assertThat(result, is(true));
    }

    @Test
    public void when1InaccurateShotThenFalse() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(2), IShip.HORIZONTAL, 1, 1);
        PlayGame play = new PlayGame(board);
        boolean result = play.shot(1, 2);
        assertThat(result, is(false));
    }

    @Test
    public void when2AccurateShotAndShipSunkenThenTrue() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(2), IShip.HORIZONTAL, 1, 1);
        PlayGame play = new PlayGame(board);
        play.shot(1, 1);
        play.shot(2, 1);
        boolean result = play.isWin();
        assertThat(result, is(true));
    }

    @Test
    public void when1AccurateAnd2InaccurateShotsAndShipNotSunkenThenFalse() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(2), IShip.HORIZONTAL, 1, 1);
        PlayGame play = new PlayGame(board);
        play.shot(1, 1);
        play.shot(1, 2);
        play.shot(1, 3);
        boolean result = play.isWin();
        assertThat(result, is(false));
    }

    @Test
    public void when1AccurateAnd2InaccurateShotsAnd1ShipSunkenAnd1ShipNotSunkenThenFalse() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(1), IShip.HORIZONTAL, 1, 1);
        board.addShip(new Ship(3), IShip.HORIZONTAL, 1, 3);
        PlayGame play = new PlayGame(board);
        play.shot(1, 1);
        play.shot(1, 2);
        play.shot(1, 3);
        boolean result = play.isWin();
        assertThat(result, is(false));
    }
}