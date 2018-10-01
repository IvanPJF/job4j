package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест вывода на консоль.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 01.10.2018
 *@version 0.1
 */
public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        String expect =
                new StringBuilder()
                        .append("*****").append(this.ln)
                        .append("*****").append(this.ln)
                        .append("*****").append(this.ln).toString();
        assertThat(new String(this.out.toByteArray()), is(expect));
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        String expect =
                new StringBuilder()
                        .append("  ^  ").append(this.ln)
                        .append(" ^^^ ").append(this.ln)
                        .append("^^^^^").append(this.ln).toString();
        assertThat(new String(this.out.toByteArray()), is(expect));
    }
}
