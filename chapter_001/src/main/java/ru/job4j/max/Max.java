package ru.job4j.max;

/**Определение максимального числа из двух.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.09.2018
 *@version 0.1
 */
public class Max {

    /**
     * Определяет максимальное число из двух.
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
