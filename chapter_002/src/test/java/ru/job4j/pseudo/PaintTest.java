package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        String ln = System.lineSeparator();
        String expect =
                new StringBuilder()
                        .append("*****").append(ln)
                        .append("*****").append(ln)
                        .append("*****").append(ln).toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        String ln = System.lineSeparator();
        String expect =
                new StringBuilder()
                        .append("  ^  ").append(ln)
                        .append(" ^^^ ").append(ln)
                        .append("^^^^^").append(ln).toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }
}
