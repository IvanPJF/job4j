package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**Тест расстояния между точками.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.09.2018
 *@version 0.1
 */
public class PointTest {

    /**
     * Тест.
     */
    @Test
    public void whenAx0y1AndBx1y2Then1Dot41PlusMinus0Dot01() {
        Point a = new Point(0, 1);
        Point b = new Point(1, 2);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(1.41, 0.01));
    }
}
