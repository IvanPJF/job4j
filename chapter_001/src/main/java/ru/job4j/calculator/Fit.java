package ru.job4j.calculator;

/**Программа расчета идеального веса.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.09.2018
 *@version 0.1
 */
public class Fit {

    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}