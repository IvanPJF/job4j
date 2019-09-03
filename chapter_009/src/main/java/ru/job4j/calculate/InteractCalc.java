package ru.job4j.calculate;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Interactive calculator.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.08.2019
 *@version 0.1
 */
public class InteractCalc {

    private Parser parser;
    private StorageOperators storageOperators;
    private String lastOperation;
    private Double result;

    public InteractCalc(final StorageOperators storageOperators) {
        this.storageOperators = storageOperators;
        this.parser = new Parser();
        this.parser.addToOperators(this.storageOperators.allOperators());
    }

    /**
     * Evaluates the proposed expression.
     * @param input Input expression.
     * @return Result of calculation.
     */
    private Double calculate(String input) {
        this.parser.parse(input);
        String operator = this.parser.isNotOperator() ? this.lastOperation : this.parser.operator();
        Double firstOperand = this.parser.isNotFirst() ? this.result : this.parser.firstOperand();
        Double secondOperand = this.parser.isNotSecond() ? this.result : this.parser.secondOperand();
        if (this.isNotNull(operator, firstOperand, secondOperand)) {
            this.result = this.storageOperators.getOperation(operator).execute(firstOperand, secondOperand);
            this.lastOperation = operator;
        }
        this.parser.clearFields();
        return this.result;
    }

    /**
     * Checking an object for null.
     * @param object Input object.
     * @return Logical result.
     */
    private boolean isNotNull(Object... object) {
        boolean result = true;
        for (Object element : object) {
            if (element == null) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Run calculator in interactive mode.
     * @param is Source expressions.
     */
    public void run(InputStream is) {
        try (Scanner sc = new Scanner(is)) {
            String wordHint = "h";
            String wordResult = this.parser.resultWord();
            String wordExit = "q";
            Menu menu = new Menu(wordHint, wordResult, wordExit);
            String expresion = null;
            do {
                menu.showMenu(this.result, this.lastOperation);
                expresion = sc.nextLine();
                if (wordHint.equals(expresion)) {
                    menu.showHint();
                    sc.nextLine();
                } else {
                    if (!wordExit.equals(expresion)) {
                        menu.showResult(this.calculate(expresion));
                    }
                }
            } while (!wordExit.equals(expresion));
        }
    }
}
