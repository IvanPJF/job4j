package ru.job4j.array;

/** Класс создает отсортированный массив на основе двух отсортированных массивов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.09.2018
 *@version 0.1
 */
public class SumArray {

    /**
     * Создаёт новый сортированный массив на основе двух отсортированных массивов.
     * @param first первый отсортированный массив.
     * @param second второй отсортированный массив.
     * @return Новый сортированный массив состоящий из двух отсортированных массивов.
     */
    public int[] third(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];
        int indexfirst = 0;
        int indexsecond = 0;
        int indexthird = 0;
        boolean work = first.length != 0 || second.length != 0;
        while (work) {
            if (indexfirst != first.length && indexsecond != second.length) {
                if (first[indexfirst] <= second[indexsecond]) {
                    third[indexthird++] = first[indexfirst++];
                } else {
                    third[indexthird++] = second[indexsecond++];
                }
            } else if (indexfirst == first.length) {
                third[indexthird++] = second[indexsecond++];
            } else {
                third[indexthird++] = first[indexfirst++];
            }
            work = indexthird != third.length;
        }
        return third;
    }
}
