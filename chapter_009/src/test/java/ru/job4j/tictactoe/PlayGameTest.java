package ru.job4j.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class PlayGameTest {

    private static final String LS = System.lineSeparator();

    @Test
    public void whenBoardSize3AndMoveHumanPlayerAndHumanPlayerPickThreeXInLineThenHumanPlayerIsWin() {
        IBoard board = new Board(3, new Cell());
        IShow show = new Show(board);
        IPlayer humanPlayer = new HumanPlayer("X", "Ivan");
        PlayGame playGame = new PlayGame(board, show);
        playGame.addPlayer(humanPlayer);
        String input = new StringJoiner(LS)
                .add("")
                .add("1").add("1")
                .add("2").add("1")
                .add("3").add("1")
                .add("n")
                .toString();
        playGame.play(new ByteArrayInputStream(input.getBytes()));
        boolean result = playGame.isWin();
        String resultWinner = playGame.winner();
        String expectedWinner = "X";
        assertThat(result, is(true));
        assertThat(resultWinner, is(expectedWinner));
    }

    @Test
    public void whenBoardSize2And4HumanPlayersAndNotWinnerThenIsWinFalseAndWinnerNull() {
        IBoard board = new Board(2, new Cell());
        IShow show = new Show(board);
        IPlayer onePlayer = new HumanPlayer("X", "Ivan");
        IPlayer twoPlayer = new HumanPlayer("O", "Zero");
        IPlayer threePlayer = new HumanPlayer("A", "Alpha");
        IPlayer fourPlayer = new HumanPlayer("W", "WWW");
        PlayGame playGame = new PlayGame(board, show);
        playGame.addPlayer(onePlayer, twoPlayer, threePlayer, fourPlayer);
        String input = new StringJoiner(LS)
                .add("")
                .add("1").add("1").add("1").add("2")
                .add("2").add("1").add("2").add("2")
                .add("n")
                .toString();
        playGame.play(new ByteArrayInputStream(input.getBytes()));
        boolean result = playGame.isWin();
        String resultWinner = playGame.winner();
        String expectedWinner = null;
        assertThat(result, is(false));
        assertThat(resultWinner, is(expectedWinner));
    }
}