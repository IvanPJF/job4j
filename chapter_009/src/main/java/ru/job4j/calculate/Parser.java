package ru.job4j.calculate;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * The expression parser.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.08.2019
 *@version 0.1
 */
public class Parser {

    private Double first;
    private Double second;
    private String operator;
    private boolean isNotFirst;
    private boolean isNotSecond;
    private boolean isNotOperator;
    private static final String RESULT_WORD = "r";
    private static final String DIGIT_PATTERN = "(?:[-]?)(?:[\\d]+|[\\d]+[.,]?[\\d]+)";
    private static String operatorsPattern = "[+\\-*/]";

    /**
     * Parses the input expression.
     * Examples of correct expressions: 1 + 2, 1 + r, r + 2, r + r, r r.
     * @param exp Input expression.
     */
    public void parse(String exp) {
        String[] arrFromExp = exp.split("[\\s]+");
        for (String value : arrFromExp) {
            if (Pattern.matches(DIGIT_PATTERN, value)) {
                if (this.first == null && !this.isNotFirst) {
                    this.first = Double.parseDouble(value);
                } else if (this.second == null) {
                    this.isNullOperator();
                    this.second = Double.parseDouble(value);
                }
            } else if (RESULT_WORD.equals(value)) {
                if (this.first == null && !this.isNotFirst) {
                    this.isNotFirst = true;
                } else if (this.second == null) {
                    this.isNullOperator();
                    this.isNotSecond = true;
                }
            } else if (Pattern.matches(operatorsPattern, value) && this.operator == null) {
                this.operator = value;
            }
            if (this.first != null && this.second != null && this.operator != null) {
                break;
            }
        }
        if (this.first != null && this.second == null) {
            this.second = this.first;
        } else if (this.second != null && this.first == null) {
            this.first = this.second;
        }
    }

    /**
     * Checking the operator field for null.
     * If the field is null, then the corresponding Boolean field is set to true.
     */
    private void isNullOperator() {
        if (this.operator == null) {
            this.isNotOperator = true;
        }
    }

    /**
     * Clearing of fields of a class.
     */
    public void clearFields() {
        this.first = null;
        this.second = null;
        this.operator = null;
        this.isNotFirst = false;
        this.isNotSecond = false;
        this.isNotOperator = false;
    }

    public Double firstOperand() {
        return this.first;
    }

    public Double secondOperand() {
        return this.second;
    }

    public String operator() {
        return this.operator;
    }

    public boolean isNotFirst() {
        return this.isNotFirst;
    }

    public boolean isNotSecond() {
        return this.isNotSecond;
    }

    public boolean isNotOperator() {
        return this.isNotOperator;
    }

    public String resultWord() {
        return RESULT_WORD;
    }

    public void addToOperators(Set<String> operators) {
        StringBuilder builder = new StringBuilder();
        for (String value : operators) {
            for (String elem : value.split("")) {
                builder.append(String.format("[%s]", elem));
            }
            builder.append("|");
        }
        operatorsPattern = String.format("%s|%s", operatorsPattern, builder.toString());
    }
}
