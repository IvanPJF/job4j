package ru.job4j.count;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Функциональный интерфейс.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 02.11.2018
 *@version 0.1
 */
public class CountFunction {

    /**
     * Вычисление функции в диапазоне.
     * @param start Начало диапазона.
     * @param end Окончание диапазона(включительно).
     * @param func Функция.
     * @return Список значений функции.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }
}