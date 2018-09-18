package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Создание сортированного массива на основе двух отсортированных массивов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.09.2018
 *@version 0.1
 */
public class SumArrayTest {

    /**
     * Тест Объединение двух отсортированных массивов в новый третий сортированный.
     */
    @Test
    public void whenTwoSortArrayIntoOneThenNewSortArray() {
        SumArray sum = new SumArray();
        int[] first = {1, 2, 3, 5, 7, 9};
        int[] second = {4, 6, 8, 10};
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = sum.third(first, second);
        assertThat(result, is(expect));
    }

    /**
     * Тест Объединение пустых массивов в третий пустой.
     */
    @Test
    public void whenTwoEmptyArrayIntoOneThenNewArrayEmpty() {
        SumArray sum = new SumArray();
        int[] first = {};
        int[] second = {};
        int[] expect = {};
        int[] result = sum.third(first, second);
        assertThat(result, is(expect));
    }

    /**
     * Тест Объединение одного отсортированного массива и одного пустого массива в третий отсортированный.
     */
    @Test
    public void whenOneSortArrayAndOneEmptyArrayIntoOneThenNewSortArray() {
        SumArray sum = new SumArray();
        int[] first = {1, 2, 4, 8, 16, 32};
        int[] second = {};
        int[] expect = {1, 2, 4, 8, 16, 32};
        int[] result = sum.third(first, second);
        assertThat(result, is(expect));
    }
}
