package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Сортировка массива пузырьком.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class BubbleSortTest {

    /**
     * Тест Сортировка массива.
     */
    @Test
    public void whenArrayNotSortThenArraySort() {
        BubbleSort array = new BubbleSort();
        int[] result = array.sort(
                new int[] {2, 5, 4, 7, 1, 9}
        );
        assertThat(result, is(
                new int[] {1, 2, 4, 5, 7, 9}
                )
        );
    }
}
