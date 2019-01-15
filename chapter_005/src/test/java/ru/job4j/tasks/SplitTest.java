package ru.job4j.tasks;

import org.junit.Test;

import java.util.List;

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

    /**
     * Массив преобразуется в два массива с приблизительно одинаковой суммой элементов.
     * Результирующие массивы содержаться в списке массивов.
     */
    @Test
    public void whenArrayToMap() {
        Split split = new Split();
        int[] input = {2, 4, 9, 5, 9, 2, 7, 8};
        int expected = sumElements(input) / 2;
        split.splitArray(input);
        List<int[]> result = split.splitArray(input);
        assertThat(expected, is(sumElements(result.get(0))));
        assertThat(expected, is(sumElements(result.get(1))));
    }
}