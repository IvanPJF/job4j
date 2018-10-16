package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**Конвертация массива в ArrayList.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.10.2018
 *@version 0.1
 */
public class ConvertMatrix2List {

    /**
     * Метод конвретирует массив в список.
     * @param array массив для конвертации в список .
     * @return список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] out : array) {
            for (int in : out) {
                list.add(in);
            }
        }
        return list;
    }
}