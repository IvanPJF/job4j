package ru.job4j.count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Функциональный интерфейс.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 02.11.2018
 *@version 0.1
 */
public class CountFunctionTest {

    /**
     * Тест.
     * Функция линейная.
     */
    @Test
    public void whenFunctionIsLinear() {
        List<Double> expect = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        List<Double> result = new CountFunction().diapason(
                0, 4,
                index -> index + 1.0
        );
        assertThat(result, is(expect));
    }

    /**
     * Тест.
     * Функция квадратичная.
     */
    @Test
    public void whenFunctionIsQuadratic() {
        List<Double> expect = new ArrayList<Double>(Arrays.asList(4.0, 1.0, 0.0, 1.0, 4.0));
        List<Double> result = new CountFunction().diapason(
                -2, 2,
                index -> Math.pow(index, 2.0)
        );
        assertThat(result, is(expect));
    }

    /**
     * Тест.
     * Функция логарифмическая.
     */
    @Test
    public void whenFunctioIsLogarithmic() {
        List<Double> expect = new ArrayList<Double>(Arrays.asList(Math.log(1.0), Math.log(2.0), Math.log(3.0)));
        List<Double> result = new CountFunction().diapason(
                1, 3,
                Math::log
        );
        assertThat(result, is(expect));
    }
}