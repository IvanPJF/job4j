package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест суммы чётных чисел в заданном диапазоне.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 11.09.2018
 *@version 0.1
 */
public class CounterTest {

    /**
     * Тест сумма четных чисел диапазона.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }
}
