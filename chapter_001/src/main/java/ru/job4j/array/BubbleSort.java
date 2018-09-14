package ru.job4j.array;

/**Сортировка массива пузырьком.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class BubbleSort {

    /**
     * Сортирует массив.
     * @param array .
     * @return Отсортированный массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
