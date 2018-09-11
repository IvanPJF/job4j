package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**Тест площади треугольника.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.09.2018
 *@version 0.1
 */
public class TriangleTest {

    /**
     * Тест Если треугольник существует.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Тест Если треугольник невозможно построить.
     */
    @Test
    public void whenNoTriangleThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, -2);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.1));
    }
}
