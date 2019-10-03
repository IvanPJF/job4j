package ru.job4j.tictactoe;

import java.util.Scanner;

/**
 * Show interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public interface IShow {

    /**
     * Create and draw a board in the console.
     *
     * @return Board in string format.
     */
    String drawBoard();

    /**
     * Ask a question and get a numerical answer.
     * @param ask Question to the user.
     * @param scanner We get the answer through interaction with the scanner.
     * @return
     */
    int askNumber(String ask, Scanner scanner);

    /**
     * Ask a question and get a string answer.
     * @param ask Question to the user.
     * @param scanner We get the answer through interaction with the scanner.
     * @return
     */
    String askString(String ask, Scanner scanner);

    /**
     * Congratulations on your victory.
     * @param text Congratulations text.
     * @param winner Winner mark.
     * @return A string of combined parameters.
     */
    String congratulationToWinner(String text, String winner);

    String getTextColumn();

    void setTextColumn(String text);

    String getTextRow();

    void setTextRow(String text);

    String getTextCongratulation();

    void setTextCongratulation(String text);

    String getTextRepeat();

    void setTextRepeat(String text);

    String getTextChoiceOrder();

    void setTextChoiceOrder(String text);
}
