package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    /**
     * Взять третий элемент связного списка.
     */
    @Test
    public void whenUseGetTwoThenResultOne() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertThat(list.get(2), is("One"));
    }

    /**
     * Удалить первый элемент связного списка.
     */
    @Test
    public void whenUseDeleteZeroThenUseGetZeroResultTwo() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete(0);
        assertThat(list.get(0), is("Two"));
    }

    /**
     * Удалить второй элемент связного списка.
     */
    @Test
    public void whenUseDeleteOneThenUseGetOneResultOne() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete(1);
        assertThat(list.get(1), is("One"));
    }

    /**
     * Удалить последний элемент связного списка.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseDeleteTwoThenUseGetTwoThrowException() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete(2);
        list.get(2);
    }

    @Test
    public void whenUsegetSizeThenThree() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertThat(list.getSize(), is(3));
    }
}