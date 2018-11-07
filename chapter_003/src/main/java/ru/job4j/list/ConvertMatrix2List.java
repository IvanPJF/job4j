package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> result = new ArrayList<>();
        Arrays.stream(array).flatMapToInt(Arrays::stream).forEach(result::add);
        return result;
    }
}