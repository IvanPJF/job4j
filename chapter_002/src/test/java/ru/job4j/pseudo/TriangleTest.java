package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenPaintTriangle() {
        Triangle result = new Triangle();
        String expect = new StringBuilder().append("  ^  \n").append(" ^^^ \n").append("^^^^^").toString();
        assertThat(result.draw(), is(expect));
    }
}
