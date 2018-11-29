package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    @Test
    public void whenUsePushElement() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("One");
        simpleStack.push("Two");
        assertThat(simpleStack.get(0), is("Two"));
        assertThat(simpleStack.get(1), is("One"));
    }

    @Test
    public void whenUsePollThenSizeIsMinusOneAndReturnFirstElement() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("One");
        simpleStack.push("Two");
        assertThat(simpleStack.getSize(), is(2));
        assertThat(simpleStack.poll(), is("Two"));
        assertThat(simpleStack.getSize(), is(1));
    }
}