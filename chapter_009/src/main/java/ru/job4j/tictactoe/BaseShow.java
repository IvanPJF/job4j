package ru.job4j.tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Show.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public abstract class BaseShow implements IShow {

    protected IBoard board;
    private Pattern digit = Pattern.compile("^[\\d]+$");
    private String textChoiceOrder = "Enter a new order or press 'Enter' to continue: ";
    private String textPickColumn = "Pick a column: ";
    private String textPickRow = "Pick a row: ";
    private String textCongratulation = "Congratulations! Won - ";
    private String textRepeat = "Repeat the game(y/n)? ";

    public BaseShow(IBoard board) {
        this.board = board;
    }

    /**
     * Ask a question and get a numerical answer.
     * @param ask Question to the user.
     * @param scanner We get the answer through interaction with the scanner.
     * @return
     */
    @Override
    public int askNumber(String ask, Scanner scanner) {
        System.out.print(ask);
        int defaultNumber = 0;
        String line = scanner.nextLine();
        Matcher matcher = this.digit.matcher(line);
        return matcher.find() ? Integer.parseInt(matcher.group()) : defaultNumber;
    }

    /**
     * Ask a question and get a string answer.
     * @param ask Question to the user.
     * @param scanner We get the answer through interaction with the scanner.
     * @return
     */
    @Override
    public String askString(String ask, Scanner scanner) {
        System.out.print(ask);
        return scanner.nextLine();
    }

    /**
     * Congratulations on your victory.
     * @param text Congratulations text.
     * @param winner Winner mark.
     * @return A string of combined parameters.
     */
    @Override
    public String congratulationToWinner(String text, String winner) {
        String result = String.format("%s%s", text, winner);
        System.out.println(result);
        return result;
    }

    @Override
    public String getTextColumn() {
        return this.textPickColumn;
    }

    @Override
    public void setTextColumn(String text) {
        this.textPickColumn = text;
    }

    @Override
    public String getTextRow() {
        return this.textPickRow;
    }

    @Override
    public void setTextRow(String text) {
        this.textPickRow = text;
    }

    @Override
    public String getTextCongratulation() {
        return this.textCongratulation;
    }

    @Override
    public void setTextCongratulation(String text) {
        this.textCongratulation = text;
    }

    @Override
    public String getTextRepeat() {
        return this.textRepeat;
    }

    @Override
    public void setTextRepeat(String text) {
        this.textRepeat = text;
    }

    @Override
    public String getTextChoiceOrder() {
        return this.textChoiceOrder;
    }

    @Override
    public void setTextChoiceOrder(String text) {
        this.textChoiceOrder = text;
    }
}
