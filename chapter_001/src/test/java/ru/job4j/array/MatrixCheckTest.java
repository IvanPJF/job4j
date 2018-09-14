package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Проверка квадратного массива на монотонность диагоналей.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class MatrixCheckTest {

    /**
     * Тест Диагонали не монотонны.
     */
    @Test
    public void whenTwoDiagonalNotMonoThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, false, false},
                {false, true, true, false, false},
                {true, false, true, false, false},
                {false, false, true, true, false},
                {false, false, true, true, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тест Диагонали монотонны.
     */
    @Test
    public void whenTwoDiagonalMonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, false},
                {false, true, false, false},
                {true, false, true, false},
                {false, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
