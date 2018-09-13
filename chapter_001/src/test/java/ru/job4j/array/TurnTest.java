package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Переворачивание массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class TurnTest {

    /**
     * Тест Переворачивание массива с чётным количеством элементов.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {5, 4, 1, 6, 2, 3};
        int[] result = turner.back(input);
        int[] expect = new int[] {3, 2, 6, 1, 4, 5};
        assertThat(result, is(expect));
    }

    /**
     * Тест Переворачивание массива с нечётным количеством элементов.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] result = turner.back(input);
        int[] expect = new int[] {7, 6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}