package ru.job4j.max;

/**Определение максимального числа.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.09.2018
 *@version 0.2
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

    /**
     * Определяет максимальное число из из трёх.
     * @param first Первое число.
     * @param second Второе число.
     * @param third Третее число.
     * @return Максимальное число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
