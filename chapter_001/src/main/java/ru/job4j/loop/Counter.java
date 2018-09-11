package ru.job4j.loop;

/**Сумма чётных чисел, заданного диапазона.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 11.09.2018
 *@version 0.1
 */
public class Counter {

    /**
     * Считаем сумму чётных чисел из заданного диапазона.
     * @param start начало диапазона.
     * @param finish окончание диапазона.
     * @return Сумма четных чисел.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}