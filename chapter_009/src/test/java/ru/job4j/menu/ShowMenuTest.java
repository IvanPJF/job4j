package ru.job4j.menu;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShowMenuTest {

    private static final String LS = System.lineSeparator();

    @Test
    public void whenShowThenParentOneChildOneChildOneOneChildTwoParentTwo() {
        IMenuEntry parentOne = new MenuEntry("ParentOne");
        IMenuEntry childOne = new MenuEntry("ChildOne", parentOne);
        IMenuEntry childOneOne = new MenuEntry("ChildOneOne", childOne);
        IMenuEntry childTwo = new MenuEntry("ChildTwo", parentOne);
        IMenuEntry parentTwo = new MenuEntry("ParentTwo");
        IMenu menu = new Menu();
        menu.addEntries(parentOne, parentTwo);
        IShowMenu show = new ShowMenu(menu);
        String result = show.show();
        String expected = new StringJoiner(LS)
                .add("ParentOne")
                .add("--ChildOne")
                .add("----ChildOneOne")
                .add("--ChildTwo")
                .add("ParentTwo")
                .toString();
        assertThat(result, is(expected));
    }

    @Test
    public void whenChangeDelimiterThenDelimiterIsPlusPlus() {
        IMenuEntry parentOne = new MenuEntry("ParentOne");
        IMenuEntry childOne = new MenuEntry("ChildOne", parentOne);
        IMenuEntry childOneOne = new MenuEntry("ChildOneOne", childOne);
        IMenuEntry parentTwo = new MenuEntry("ParentTwo");
        IMenu menu = new Menu();
        menu.addEntries(parentOne, parentTwo);
        IShowMenu show = new ShowMenu(menu);
        show.setDelimiter("++");
        String result = show.show();
        String expected = new StringJoiner(LS)
                .add("ParentOne")
                .add("++ChildOne")
                .add("++++ChildOneOne")
                .add("ParentTwo")
                .toString();
        assertThat(result, is(expected));
    }
}