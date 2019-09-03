package ru.job4j.calculate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EngineerCalcTest {

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String LS = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOut() {
        System.setOut(this.stdOut);
    }

    @Test
    public void whenCalcSinThenResult() {
        StorageOperators storage = new StorageOperators();
        storage.addOperator(new EngineerCalc.SinOperation("sin"));
        InteractCalc iCalc = new InteractCalc(storage);
        EngineerCalc engeeCalc = new EngineerCalc(iCalc);
        Double resMath = Math.sin(1);
        String expected = new StringJoiner(LS)
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add(String.format("Expression result: %s", resMath))
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add(String.format("Last result(r): %s", resMath))
                .add("Last operation: sin")
                .add("")
                .toString();
        String input = new StringJoiner(LS)
                .add("sin 1")
                .add("q").toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        engeeCalc.run(bais);
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }
}