package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    private SimpleArray<Integer> simpleArray = new SimpleArray<>(3);

    @Before
    public void addIntElementInSimpleArray() {
        simpleArray.add(1);
        simpleArray.add(3);
        simpleArray.add(9);
    }

    @Test
    public void whenGetTwoElementsThenThree() {
        assertThat(simpleArray.get(1), is(3));
    }

    @Test
    public void whenGetInvalidIndexThenNull() {
        assertThat(simpleArray.get(10), is((Integer) null));
    }

    @Test
    public void whenSetOneElementThenReturnValueOneElementAndEditOneElement() {
        assertThat(simpleArray.set(0, 12), is(1));
        assertThat(simpleArray.get(0), is(12));
    }

    @Test
    public void whenSetInvalidIndexThenNull() {
        assertThat(simpleArray.set(10, 12), is((Integer) null));
    }

    @Test
    public void whenDeleteTwoElementThenTwoElementIsNine() {
        simpleArray.delete(1);
        assertThat(simpleArray.get(1), is(9));
    }

    @Test
    public void whenDeleteLastElementThenLastElementIsNull() {
        simpleArray.delete(2);
        assertThat(simpleArray.get(2), is((Integer) null));
    }

    @Test(expected = ContainerIsFullException.class)
    public void shouldThrowContainerIsFullException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        simpleArray.add(1);
    }

    @Test
    public void whenAddStringElementsInSimpleArrayAndGetThreeElementThenThree() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("One");
        simpleArray.add("Two");
        simpleArray.add("Three");
        assertThat(simpleArray.get(2), is("Three"));
    }

    @Test
    public void whenSequentialTakeElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("One");
        simpleArray.add("Two");
        simpleArray.add("Three");
        Iterator<String> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("One"));
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.next(), is("Three"));
        assertThat(iterator.next(), is((String) null));
        assertThat(iterator.hasNext(), is(false));
    }
}