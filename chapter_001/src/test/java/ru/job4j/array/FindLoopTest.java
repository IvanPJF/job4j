package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест поиска заданного числа в массиве.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class FindLoopTest {

    /**
     * Тест Поиск заданного числа в массиве(если число в массиве имеется).
     */
    @Test
    public void whenArrayHasLengh29Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 29, 7};
        int value = 29;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * Тест Поиск заданного числа в массиве(если число в массиве отсутствует).
     */
    @Test
    public void whenArrayNotHaveMatchNumberThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 29, 7};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}