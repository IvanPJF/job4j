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

    private int[] arrOne;
    private int[] arrTwo;
    private int sumOne;
    private int sumTwo;

    /**
     * Деление массива на 2 новых массива.
     * @param array Входной массив.
     */
    public void splitArray(int[] array) {
        NavigableMap<Integer, Integer> map = this.arrayToMap(array);
        List<Integer> listOne = new LinkedList<>();
        List<Integer> listTwo = new LinkedList<>();
        while (!map.isEmpty()) {
            Integer value = this.takeElement(map);
            if (this.sumOne <= this.sumTwo) {
                listOne.add(value);
                this.sumOne += value;
            } else {
                listTwo.add(value);
                this.sumTwo += value;
            }
        }
        this.arrOne = this.listToArray(listOne);
        this.arrTwo = this.listToArray(listTwo);
    }

    /**
     * Конвертация массива в Map.
     * @param array Входной массив.
     * @return Map, содержащая эл-ты массива.
     */
    private NavigableMap<Integer, Integer> arrayToMap(int[] array) {
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int value : array) {
            Integer count = map.get(value);
            map.put(value, count == null ? 1 : ++count);
        }
        return map;
    }

    /**
     * Конвертация списка в массив.
     * @param list Входной список.
     * @return Массив, содержащий эл-ты списка.
     */
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * Взять самый большой ключ из Map.
     * @param map Входной Map.
     * @return Самый большой ключ в Map.
     */
    private Integer takeElement(NavigableMap<Integer, Integer> map) {
        Integer value = map.lastKey();
        Integer count = map.get(value);
        if (count > 1) {
            map.replace(value, --count);
        } else {
            map.remove(value);
        }
        return value;
    }

    public int[] getArrOne() {
        return this.arrOne;
    }

    public int[] getArrTwo() {
        return this.arrTwo;
    }
}
