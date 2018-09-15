package ru.job4j.array;

import java.util.Arrays;

/**Удаление дубликатов в массиве.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 15.09.2018
 *@version 0.1
 */
public class ArrayDuplicate {

    /**
     * Удаляем дубликаты в массиве.
     * @param array целевой массив.
     * @return Результат проверки.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
