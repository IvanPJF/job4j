package ru.job4j.tasks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitTest {

    /**
     * Сумма элементов массива.
     * @param array Входной массив.
     * @return Результат суммирования.
     */
    public int sumElements(int[] array) {
        int result = 0;
        for (int value : array) {
            result += value;
        }
        return result;
    }

    @Test
    public void whenArrayToMap() {
        Split split = new Split();
        int[] input = {2, 4, 9, 5, 9, 2, 7, 8};
        int[] outOne = {9, 8, 4, 2};
        int[] outTwo = {9, 7, 5, 2};
        split.splitArray(input);
        assertThat(sumElements(outOne), is(sumElements(outTwo)));
        assertThat(outOne, is(split.getArrOne()));
        assertThat(outTwo, is(split.getArrTwo()));
    }
}