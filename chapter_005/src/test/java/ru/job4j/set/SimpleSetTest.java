package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Множество на основе динамического массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.11.2018
 *@version 0.1
 */
public class SimpleSetTest {

    /**
     * Добавление элементов без дубликатов.
     */
    @Test
    public void whenAddNotDuplicateElement() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("Three");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is("One"));
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.next(), is("Three"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Добавление элементов с дубликатом(дубликат не добавляется).
     */
    @Test
    public void whenAddDuplicateElement() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("One");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is("One"));
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Проверка количества элементов множества.
     */
    @Test
    public void whenUseGetsizeThenThree() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("Three");
        assertThat(simpleSet.getSize(), is(3));
    }
}