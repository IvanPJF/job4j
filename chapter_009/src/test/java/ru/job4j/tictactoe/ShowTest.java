package ru.job4j.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShowTest {

    private static final String LS = System.lineSeparator();

    @Test
    public void whenBoardSize2ThenDrawBoard2x2() {
        IShow show = new Show(new Board(2, new Cell()));
        String expected = new StringJoiner(LS)
                .add("  1    2  ")
                .add("==========")
                .add("|   ||   | 1")
                .add("==========")
                .add("|   ||   | 2")
                .add("==========")
                .add("")
                .toString();
        String result = show.drawBoard();
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseAskNumberAndScannerInput1Then1() {
        int result = -1;
        int expected = 1;
        InputStream is = new ByteArrayInputStream(String.valueOf(expected).getBytes());
        try (Scanner scanner = new Scanner(is)) {
            IShow show = new Show(new Board(2, new Cell()));
            result = show.askNumber("", scanner);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseAskNumberAndScannerInputTypeStringThen0() {
        int result = -1;
        int expected = 0;
        String input = "Any word";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        try (Scanner scanner = new Scanner(is)) {
            IShow show = new Show(new Board(2, new Cell()));
            result = show.askNumber("", scanner);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseAskStringAndScannerInputTypeStringThenReturnWord() {
        String result = null;
        String input = "Any word";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        try (Scanner scanner = new Scanner(is)) {
            IShow show = new Show(new Board(2, new Cell()));
            result = show.askString("", scanner);
        }
        assertThat(result, is(input));
    }

    @Test
    public void whenUseAskStringAndScannerInputLineSeparatorThenReturnEmpty() {
        String result = null;
        String expected = "";
        InputStream is = new ByteArrayInputStream(LS.getBytes());
        try (Scanner scanner = new Scanner(is)) {
            IShow show = new Show(new Board(2, new Cell()));
            result = show.askString("", scanner);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseCongratulationInputTextAndWinnerThenReturnUnionTextAndWinner() {
        String congratulation = "Congratulation! Won - ";
        String winner = "X";
        String expected = String.format("%s%s", congratulation, winner);
        IShow show = new Show(new Board(2, new Cell()));
        String result = show.congratulationToWinner(congratulation, winner);
        assertThat(result, is(expected));
    }
}