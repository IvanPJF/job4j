package ru.job4j.calculate;

/**Class for calculating arithmetic operations.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.09.2018
 *@version 0.1
 */
public class Calculator {

    /**
     *Field result.
     */
    private double result;

    /**
     * Method add.
     * @param first First operator.
     * @param second Second operator.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     * @param first First operator.
     * @param second Second operator.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method multiple.
     * @param first First operator.
     * @param second Second operator.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method div.
     * @param first First operator.
     * @param second Second operator.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method display field result.
     * @return value field result.
     */
    public double getResult() {
        return this.result;
    }
}