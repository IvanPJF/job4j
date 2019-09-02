package ru.job4j.calculate;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MenuTest {

    private static final String LS = System.lineSeparator();

    @Test
    public void whenUseShowMenu() {
        Menu menu = new Menu("h", "r", "q");
        String expected = new StringJoiner(LS)
                .add("Enter a new expression. For hint (h). For exit (q)")
                .add("Last result(r): 1.0")
                .add("Last operation: +")
                .toString();
        String result = menu.showMenu(1.0, "+");
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseShowHint() {
        Menu menu = new Menu("h", "r", "q");
        String expected = new StringJoiner(LS)
                .add("To repeat the last operation, you do not need to enter an operator.")
                .add("To use the result of the previous expression - instead of a number, enter the word (r)")
                .toString();
        String result = menu.showHint();
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseShowResult() {
        Menu menu = new Menu("h", "r", "q");
        Double number = 1.0;
        String expected = String.format("Expression result: %s", number);
        String result = menu.showResult(number);
        assertThat(result, is(expected));
    }
}