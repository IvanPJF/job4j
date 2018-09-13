package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест заполнения массива степенями чисел.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class SquareTest {

    /**
     * Тест Массив из трёх чисел.
     */
    @Test
    public void whenBound3Then149() {
        Square square = new Square();
        int[] rst = square.calculate(3);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Тест Массив из семи чисел.
     */
    @Test
    public void whenBound7Then14916253649() {
        Square square = new Square();
        int[] rst = square.calculate(7);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36, 49};
        assertThat(rst, is(expect));
    }

    /**
     * Тест Пустой массив.
     */
    @Test
    public void whenBound0ThenEmpty() {
        Square square = new Square();
        int[] rst = square.calculate(0);
        int[] expect = new int[] {};
        assertThat(rst, is(expect));
    }
}
