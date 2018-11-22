package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<String> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
    }

    /**
     * Взять третий элемент связного списка.
     */
    @Test
    public void whenUseGetTwoThenResultOne() {
        assertThat(list.get(2), is("One"));
    }

    /**
     * Удалить первый элемент связного списка.
     */
    @Test
    public void whenUseDeleteZeroThenUseGetZeroResultTwo() {
        list.delete(0);
        assertThat(list.get(0), is("Two"));
    }

    /**
     * Удалить второй элемент связного списка.
     */
    @Test
    public void whenUseDeleteOneThenUseGetOneResultOne() {
        list.delete(1);
        assertThat(list.get(1), is("One"));
    }

    /**
     * Удалить последний элемент связного списка.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseDeleteTwoThenUseGetTwoThrowException() {
        list.delete(2);
        list.get(2);
    }

    @Test
    public void whenUsegetSizeThenThree() {
        assertThat(list.getSize(), is(3));
    }
}