package ru.job4j.tictactoe;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PlayGame.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public class PlayGame {

    private final IBoard board;
    private final IShow show;
    private Map<Integer, IPlayer> players = new TreeMap<>();
    private boolean isWin;
    private String winner;
    private static final String REPEAT_GAME = "y";
    private Pattern digit = Pattern.compile("\\b[\\d]+\\b");

    public PlayGame(IBoard board, IShow show) {
        this.board = board;
        this.show = show;
    }

    /**
     * Game launch.
     * @param input Input resource.
     */
    public void play(InputStream input) {
        try (Scanner scanner = new Scanner(input)) {
            loopChangeOrder(scanner);
            boolean work = true;
            while (work) {
                for (IPlayer player : this.players.values()) {
                    player.move(this.board, this.show, scanner);
                    this.isWin = this.board.isWin();
                    if (this.isWin || this.board.isFilled()) {
                        this.show.drawBoard();
                        this.winner = this.isWin ? this.board.lastCell().getMark() : null;
                        if (this.isWin) {
                            this.show.congratulationToWinner(this.show.getTextCongratulation(), this.winner);
                        }
                        work = isRepeat(scanner);
                        break;
                    }
                }
            }
        }
    }

    public void addPlayer(IPlayer... players) {
        for (IPlayer player : players) {
            this.players.put(this.players.size(), player);
        }
    }

    private void loopChangeOrder(Scanner scanner) {
        String newOrder = null;
        do {
            String stringPlayers = playersToString();
            newOrder = this.show.askString(
                    String.format("%s%n%s", stringPlayers, this.show.getTextChoiceOrder()), scanner
            );
            changeOrder(newOrder);
        } while (!newOrder.isEmpty());
    }

    private void changeOrder(String newOrder) {
        Map<Integer, IPlayer> newPlayers = new TreeMap<>();
        Matcher matcher = this.digit.matcher(newOrder);
        while (matcher.find()) {
            Integer key = Integer.parseInt(matcher.group());
            IPlayer value = this.players.remove(key);
            if (value != null) {
                newPlayers.put(newPlayers.size(), value);
            }
        }
        for (IPlayer player : this.players.values()) {
            newPlayers.put(newPlayers.size(), player);
        }
        this.players = newPlayers;
    }

    private String playersToString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Map.Entry<Integer, IPlayer> entry : this.players.entrySet()) {
            joiner.add(String.format("%d. %s", entry.getKey(), entry.getValue()));
        }
        return joiner.toString();
    }

    /**
     * You will be asked to repeat the game.
     * If agreed, the game will restart, otherwise the game will end.
     * @param scanner We get the answer through interaction with the scanner.
     * @return The logical result of the response.
     */
    private boolean isRepeat(Scanner scanner) {
        String answer = this.show.askString(this.show.getTextRepeat(), scanner);
        boolean repeat = REPEAT_GAME.equals(answer);
        if (repeat) {
            this.board.clearBoard();
            this.isWin = false;
        }
        return repeat;
    }

    /**
     * Check victory status.
     * @return
     */
    public boolean isWin() {
        return this.isWin;
    }

    /**
     * Get the winner label.
     * @return
     */
    public String winner() {
        return this.winner;
    }
}
