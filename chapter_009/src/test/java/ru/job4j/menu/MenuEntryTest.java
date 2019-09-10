package ru.job4j.menu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MenuEntryTest {

    @Test
    public void whenCreateMenuEntryWithNameParentThenGetNameReturnStringParent() {
        IMenuEntry parent = new MenuEntry("Parent");
        String expected = "Parent";
        assertThat(parent.getName(), is(expected));
    }

    @Test
    public void whenCreateMenuEntryWithParentThenGetParentReturnParent() {
        IMenuEntry parent = new MenuEntry("Parent");
        IMenuEntry child = new MenuEntry("Child", parent);
        IMenuEntry result = child.getParent();
        assertThat(result, is(parent));
    }

    @Test
    public void whenCreateMenuEntryWithParentThenInvokeGetChildrenParentReturnParentChildren() {
        IMenuEntry parent = new MenuEntry("Parent");
        IMenuEntry childOne = new MenuEntry("ChildOne", parent);
        IMenuEntry childTwo = new MenuEntry("ChildTwo", parent);
        Set<IMenuEntry> result = parent.getChildren();
        Set<IMenuEntry> expected = new TreeSet<>(Arrays.asList(childOne, childTwo));
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByNameThenSuitableMenuEntry() {
        IMenuEntry parent = new MenuEntry("Parent");
        IMenuEntry childOne = new MenuEntry("ChildOne", parent);
        IMenuEntry childTwo = new MenuEntry("ChildTwo", parent);
        IMenuEntry resultParent = parent.findByName("Parent");
        IMenuEntry resultChildOne = parent.findByName("ChildOne");
        IMenuEntry resultChildTwo = parent.findByName("ChildTwo");
        assertThat(resultParent, is(parent));
        assertThat(resultChildOne, is(childOne));
        assertThat(resultChildTwo, is(childTwo));
    }
}