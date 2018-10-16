package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * Тест Конвертация - список массивов int в список.
     */
    @Test
    public void whenListMatrixElementsThenList() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 3, 5, 7});
        list.add(new int[]{9, 11});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 3, 5, 7, 9, 11);
        assertThat(result, is(expect));
    }
}