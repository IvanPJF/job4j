package ru.job4j.array;

/**Переворачивание массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class Turn {

    /**
     * Переворачивает массив.
     * @param array целевой массив.
     * @return перевёрнутый массив.
     */
    public int[] back(int[] array) {
        int temp;
        int size = array.length;
        for (int index = 0; index < size / 2; index++) {
            temp = array[index];
            array[index] = array[size - index - 1];
            array[size - index - 1] = temp;
        }
        return array;
    }
}