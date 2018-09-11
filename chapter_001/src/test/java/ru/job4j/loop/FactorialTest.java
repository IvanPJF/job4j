package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Вычисление факториала.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 11.09.2018
 *@version 0.1
 */
public class FactorialTest {

    /**
     * Тест вычисления факториала.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial count = new Factorial();
        int result = count.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Тест факториал от 0.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial count = new Factorial();
        int result = count.calc(0);
        assertThat(result, is(1));
    }
}
