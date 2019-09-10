package ru.job4j.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {

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
    public void whenUseRunForOneMenuEntryAndSelectExit() {
        IMenuEntry parent = new MenuEntry("Parent");
        IMenu menu = new Menu();
        menu.addEntries(parent);
        IShowMenu show = new ShowMenu(menu);
        StartUI startUI = new StartUI(menu, show);
        String input = new StringJoiner(LS)
                .add("q").toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        startUI.run(bais);
        String expected = new StringJoiner(LS)
                .add("Parent")
                .add("Select menu item (for exit \"q\"): ")
                .add("").toString();
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseRunForOneMenuEntryAndSelectParentExecuteAndSelectExit() {
        String message = "Action for the parent is made";
        IMenuEntry parent = new MenuEntry("Parent");
        parent.setAction(() -> {
            System.out.println(message);
            return true;
        });
        IMenu menu = new Menu();
        menu.addEntries(parent);
        IShowMenu show = new ShowMenu(menu);
        StartUI startUI = new StartUI(menu, show);
        String input = new StringJoiner(LS)
                .add("Parent")
                .add("q").toString();
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        startUI.run(bais);
        String expected = new StringJoiner(LS)
                .add("Parent")
                .add("Select menu item (for exit \"q\"): ")
                .add(message)
                .add("Parent")
                .add("Select menu item (for exit \"q\"): ")
                .add("").toString();
        String result = new String(this.out.toByteArray());
        assertThat(result, is(expected));
    }
}