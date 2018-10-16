package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Конвертация ArrayList в массив.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.10.2018
 *@version 0.1
 */
public class ConvertList2ArrayTest {

    /**
     * Тест Конвертация - 7 элементов списка в 9 элементов массива.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
}