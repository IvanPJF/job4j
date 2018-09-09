package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест определения максимального числа.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.09.2018
 *@version 0.1
 */
public class MaxTest {

    /**
     * Тест Первое число максимально.
     */
    @Test
    public void when2Over1Then2() {
        Max maximum = new Max();
        assertThat(
                maximum.max(2, 1),
                is(2)
        );
    }

    /**
     * Тест Второе число максимально.
     */
    @Test
    public void when2Under3Then3() {
        Max maximum = new Max();
        assertThat(
                maximum.max(2, 3),
                is(3)
        );
    }


    /**
     * Тест Числа равны.
     */
    @Test
    public void when4Equally4Then4() {
        Max maximum = new Max();
        assertThat(
                maximum.max(4, 4),
                is(4)
        );
    }
}

