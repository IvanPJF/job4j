package ru.job4j.calculate;

import java.util.StringJoiner;

/**
 * Menu for user interaction calculator.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.08.2019
 *@version 0.1
 */
public class Menu {

    private String wordHint;
    private String wordResult;
    private String wordExit;
    private String mainMenu;
    private String hint;
    private static final String LS = System.lineSeparator();

    public Menu(String wordHint, String wordResult, String wordExit) {
        this.wordHint = wordHint;
        this.wordResult = wordResult;
        this.wordExit = wordExit;
        this.fillText();
    }

    /**
     * Filling in the fields with the required text.
     */
    private void fillText() {
        this.mainMenu = String.format("Enter a new expression. For hint (%s). For exit (%s)", this.wordHint, this.wordExit);
        this.hint = new StringJoiner(LS)
                .add("To repeat the last operation, you do not need to enter an operator.")
                .add(String.format("To use the result of the previous expression - instead of a number, enter the word (%s)", this.wordResult))
                .toString();
    }

    /**
     * Show menu
     * @param lastResult Result of last expression.
     * @param lastOperation The operator of the last expression.
     */
    public String showMenu(Double lastResult, String lastOperation) {
        StringJoiner sj = new StringJoiner(LS)
                .add(this.mainMenu);
        if (lastResult != null && lastOperation != null) {
            sj.add(String.format("Last result(%s): %s", this.wordResult, lastResult))
                    .add(String.format("Last operation: %s", lastOperation));
        }
        String out = sj.toString();
        System.out.println(out);
        return out;
    }

    /**
     * Show hint.
     */
    public String showHint() {
        System.out.println(this.hint);
        return this.hint;
    }

    /**
     * Show the result in a specific format.
     * @param result The result of the input without formatting.
     */
    public String showResult(Double result) {
        String out = String.format("Expression result: %s", result);
        System.out.println(out);
        return out;
    }
}
