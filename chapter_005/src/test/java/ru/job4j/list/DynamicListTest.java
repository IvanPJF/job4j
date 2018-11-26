package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест связного списка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.11.2018
 *@version 0.1
 */
public class DynamicListTest {

    private DynamicList<Integer> dynamicList = new DynamicList<>();
    private Iterator<Integer> iterator;

    /**
     * Добавление элементов в связный спискок.
     * Создание итератора.
     */
    @Before
    public void setUp() {
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
        iterator = dynamicList.iterator();
    }

    /**
     * Использование метода get() для всех элементов списка.
     */
    @Test
    public void whenUseGetZeroOneTwoThenResultThreeTwoOne() {
        assertThat(dynamicList.get(0), is(3));
        assertThat(dynamicList.get(1), is(2));
        assertThat(dynamicList.get(2), is(1));
    }

    /**
     * Использование итератора.
     */
    @Test
    public void whenUseIterator() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Ошибка возникающая при использовании, прежде созданного итератора, после изменения структуры связного списка.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAfterLengthChangeDynamicListThenException() {
        dynamicList.add(4);
        iterator.next();
    }

    /**
     * Ошибка возникающая при отсутствии следующего элемента после вызова метода next().
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNoElementInList() {
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    /**
     * Ошибка возникающая при неправильно заданном индексе элемента списка.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseGetInvalidIndexThenException() {
        dynamicList.get(10);
    }

    /**
     * Количество элементов списка.
     */
    @Test
    public void whenUseGetsizeThenResultThree() {
        assertThat(dynamicList.getSize(), is(3));
    }
}