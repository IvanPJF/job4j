package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void whenPaintSquare() {
        Square result = new Square();
        String expect = new StringBuilder().append("*****\n").append("*****\n").append("*****").toString();
        assertThat(result.draw(), is(expect));
    }
}
