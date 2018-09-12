package ru.job4j.loop;

/**Вычисление факториала.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 11.09.2018
 *@version 0.1
 */
public class Factorial {

    /**
     * Вычисляет факториал.
     * @param n значение факториала.
     * @return Рассчитанный факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
