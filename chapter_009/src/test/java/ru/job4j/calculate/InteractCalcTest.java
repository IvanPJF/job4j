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

public class InteractCalcTest {

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
    public void whenUseRunAndInput1Plus2() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        storage.addOperator(new StorageOperators.AddOperation(calc, "+"));
        InteractCalc iCalc = new InteractCalc(storage);
        String input = new StringJoiner(LS)
                .add("1 + 2")
                .add("q").toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        iCalc.run(bais);
        String expected = new StringJoiner(LS)
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("Expression result: 3.0")
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("Last result(r): 3.0")
                .add("Last operation: +")
                .add("")
                .toString();
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseRunAndInputHint() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        storage.addOperator(new StorageOperators.AddOperation(calc, "+"));
        InteractCalc iCalc = new InteractCalc(storage);
        String input = new StringJoiner(LS)
                .add("h")
                .add("")
                .add("q").toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        iCalc.run(bais);
        String expected = new StringJoiner(LS)
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("To repeat the last operation, you do not need to enter an operator.")
                .add("To use the result of the previous expression - instead of a number, enter the word (r)")
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("")
                .toString();
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseRunAndInputQ() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        storage.addOperator(new StorageOperators.AddOperation(calc, "+"));
        InteractCalc iCalc = new InteractCalc(storage);
        String input = new StringJoiner(LS)
                .add("q")
                .toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        iCalc.run(bais);
        String expected = new StringJoiner(LS)
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("")
                .toString();
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }
}