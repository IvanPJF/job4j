package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Построение шахматной доски в псевдографике.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.09.2018
 *@version 0.1
 */
public class BoardTest {

    /**
     * Тест Шахматной доски 3x3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    /**
     * Тест Шахматной доски 5x4.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }
}