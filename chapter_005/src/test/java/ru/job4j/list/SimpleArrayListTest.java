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
    public void whenUseDeleteThenUseGetZeroResultTwo() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete();
        assertThat(list.get(0), is("Two"));
    }

    /**
     * Удалить первый и второй элементы связного списка.
     */
    @Test
    public void whenUseDeleteTwoTimesThenUseGetZeroResultOne() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete();
        list.delete();
        assertThat(list.get(0), is("One"));
    }

    /**
     * Удалить первый элемент связного списка и попытаться взять элемент по несуществующему индексу.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseDeleteThenUseGetTwoThrowException() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete();
        list.get(2);
    }

    /**
     * Узнать размер связанного списка.
     */
    @Test
    public void whenUsegetSizeThenThree() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertThat(list.getSize(), is(3));
    }

    /**
     * Размер связанного списка после использования метода delete().
     */
    @Test
    public void whenUsegetSize() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("One");
        int sizeFirst = list.getSize();
        list.delete();
        int sizeSecond = list.getSize();
        list.delete();
        int sizeThird = list.getSize();
        assertThat(sizeFirst, is(1));
        assertThat(sizeSecond, is(0));
        assertThat(sizeThird, is(0));
    }

    /**
     * Использование метода delete() на пустом списке.
     */
    @Test
    public void whenUseDeleteForZeroSizeListThenResultNull() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        assertThat(list.delete(), is((String) null));
    }
}