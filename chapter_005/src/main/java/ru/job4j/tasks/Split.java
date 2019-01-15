package ru.job4j.tasks;

import java.util.*;

/**
 * Разделение массива.
 * Массив делится на 2 массива.
 * Сумма элементов 1 массива равняется или приблизительна сумме элементов 2 массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.01.2019
 *@version 0.1
 */
public class Split {
    static final int OUT_SIZE = 2;
    /**
     * Деление массива на два массива с приблизительно одинаковой суммой элементов.
     * @param array Входной массив.
     * @return Список массивов с приблизительно одинаковой суммой элементов.
     */
    public List<int[]> splitArray(int[] array) {
        int sumOne = 0, sumTwo = 0;
        List<Integer> oneList = new LinkedList<>();
        List<Integer> twoList = new LinkedList<>();
        List<int[]> result = new ArrayList<>(OUT_SIZE);
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            if (sumOne <= sumTwo) {
                oneList.add(array[i]);
                sumOne += array[i];
            } else {
                twoList.add(array[i]);
                sumTwo += array[i];
            }
        }
        result.add(oneList.stream().mapToInt(Integer::intValue).toArray());
        result.add(twoList.stream().mapToInt(Integer::intValue).toArray());
        return result;
    }
}
