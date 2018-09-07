package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**Тест идеального веса.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.09.2018
 *@version 0.1
 */
public class FitTest {

    /**
     * Тест идеального веса для мужчины.
     */
    @Test
    public void whenHeight180ThenWeight92PlusMinus0Dot1() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Тест идеального веса для женщины.
     */
    @Test
    public void whenHeight170ThenWeight69PlusMinus0Dot1() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
