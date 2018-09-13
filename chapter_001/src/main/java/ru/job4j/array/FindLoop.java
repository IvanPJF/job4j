package ru.job4j.array;

/**Поиск заданного числа в массиве.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class FindLoop {

    /**
     * Ищет заданное число в массиве.
     * @param data целевой массив.
     * @param el искомый элемент.
     * @return индекс массива.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}