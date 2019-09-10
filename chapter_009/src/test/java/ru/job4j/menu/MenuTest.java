package ru.job4j.menu;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MenuTest {

    @Test
    public void whenAddEntryThenMenuContainsEntry() {
        IMenu menu = new Menu();
        IMenuEntry parent = new MenuEntry("Parent");
        menu.addEntries(parent);
        Set<IMenuEntry> expected = new TreeSet<>(Collections.singletonList(parent));
        Set<IMenuEntry> result = menu.getAll();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByNameChildOneOneThenGetChildOneOneEntry() {
        IMenu menu = new Menu();
        IMenuEntry parent = new MenuEntry("Parent");
        IMenuEntry childOne = new MenuEntry("ChildOne", parent);
        IMenuEntry childOneOne = new MenuEntry("ChildOneOne", childOne);
        menu.addEntries(parent);
        IMenuEntry result = menu.findByName("ChildOneOne");
        assertThat(result, is(childOneOne));
    }
}