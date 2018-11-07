package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Конвертация ArrayList в массив.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.10.2018
 *@version 0.1
 */
public class ConvertList2Array {

    /**
     * Метод конвретирует список в массив.
     * @param list список для конвертации в массив.
     * @param rows количество строк массива.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] result = new int[rows][cells];
        list.forEach(
                value -> result[list.indexOf(value) / rows][list.indexOf(value) % cells] = value
        );
        return result;
    }

    /**
     * Метод конвертирует список массивов int в список.
     * @param list список для конвертации в массив.
     * @return список.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        list.stream().flatMapToInt(Arrays::stream).forEach(result::add);
        return result;
    }
}