package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray = new DynamicArray<>(3);

    @Before
    public void addElement() {
        this.dynamicArray.add(1);
        this.dynamicArray.add(2);
        this.dynamicArray.add(3);
    }

    @Test
    public void whenAddElementThenArrayHasGrown() {
        this.dynamicArray.add(4);
        assertThat(this.dynamicArray.get(0), is(1));
        assertThat(this.dynamicArray.get(1), is(2));
        assertThat(this.dynamicArray.get(2), is(3));
        assertThat(this.dynamicArray.get(3), is(4));
    }

    @Test
    public void whenLengthArrayIsZeroAndAddOneElementThenUseGetZeroResultOne() {
        this.dynamicArray = new DynamicArray<>(0);
        this.dynamicArray.add(1);
        assertThat(this.dynamicArray.get(0), is(1));
    }

    @Test
    public void whenUseIterator() {
        Iterator<Integer> iterator = this.dynamicArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAfterLengthChangeDynamicArray() {
        Iterator<Integer> iterator = this.dynamicArray.iterator();
        this.dynamicArray.add(4);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElementInList() {
        this.dynamicArray = new DynamicArray<>();
        Iterator<Integer> iterator = this.dynamicArray.iterator();
        iterator.next();
    }
}