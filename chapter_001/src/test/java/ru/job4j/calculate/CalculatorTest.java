package ru.job4j.calculate;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**Тест
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.09.2018
 *@version 0.1
 */
public class CalculatorTest {

    /**
     * Test add.
     */
    @Test
    public void whenAddEightPlusTwoThenTen() {
        Calculator calc = new Calculator();
        calc.add(8D, 2D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenSubtractEightMinusTwoThenSix() {
        Calculator calc = new Calculator();
        calc.subtract(8D, 2D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */
    @Test
    public void whenMultipleEightByTwoThenSixteen() {
        Calculator calc = new Calculator();
        calc.multiple(8D, 2D);
        double result = calc.getResult();
        double expected = 16D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenDivEightByTwoThenFour() {
        Calculator calc = new Calculator();
        calc.div(8D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}