package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Простой HashMap.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.12.2018
 *@version 0.1
 */
public class SimpleHashMapTest {

    /**
     * Добавление пар ключ-значение в таблицу.
     */
    @Test
    public void whenUseAddThenTrue() {
        SimpleHashMap<String, String> sHashMap = new SimpleHashMap<>(31);
        assertThat(sHashMap.insert("First", "One"), is(true));
        assertThat(sHashMap.insert("Second", "Two"), is(true));
        assertThat(sHashMap.insert("Third", "Three"), is(true));
        assertThat(sHashMap.insert("Fourth", "Four"), is(true));
    }

    /**
     * Увеличение размера таблицы при недостатке места для новой пары.
     */
    @Test
    public void whenUseAddThenTableIsIncrease() {
        SimpleHashMap<Integer, String> sHashMap = new SimpleHashMap<>(3);
        assertThat(sHashMap.insert(1, "One"), is(true));
        assertThat(sHashMap.insert(2, "Two"), is(true));
        assertThat(sHashMap.insert(3, "Three"), is(true));
        assertThat(sHashMap.insert(4, "Four"), is(true));
    }

    /**
     * Добавление пары ключ-значение в таблицу с ключом - null.
     * Пара добавляется в ячейку с нулевым индексом.
     * По ключу достать значение не получится.
     * Вывод значения производится при помощи итератора.
     */
    @Test
    public void whenUseAddKeyNullThenAddToIndexZero() {
        SimpleHashMap<String, String> sHashMap = new SimpleHashMap<>(3);
        sHashMap.insert(null, "One");
        Iterator iterator = sHashMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("One"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Поиск значения по ключу.
     */
    @Test
    public void whenUseGet() {
        SimpleHashMap<String, String> sHashMap = new SimpleHashMap<>(31);
        sHashMap.insert("Ivan", "One");
        sHashMap.insert("Navi", "Two");
        assertThat(sHashMap.get("Ivan"), is("One"));
        assertThat(sHashMap.get("Navi"), is("Two"));
    }

    /**
     * Удаление пары ключ-значение по ключу.
     */
    @Test
    public void whenUseDeleteNaviThenTrue() {
        SimpleHashMap<String, String> sHashMap = new SimpleHashMap<>();
        sHashMap.insert("Ivan", "One");
        sHashMap.insert("Navi", "Two");
        assertThat(sHashMap.get("Navi"), is("Two"));
        assertThat(sHashMap.delete("Navi"), is(true));
        assertThat(sHashMap.get("Navi"), is((String) null));
    }

    /**
     * Удаление пары ключ-значение по ключу не выполнилось в связи с неверным ключом.
     */
    @Test
    public void whenUseDeleteTwoThenFalse() {
        SimpleHashMap<String, String> sHashMap = new SimpleHashMap<>();
        sHashMap.insert("Ivan", "One");
        sHashMap.insert("Navi", "Two");
        assertThat(sHashMap.get("Navi"), is("Two"));
        assertThat(sHashMap.delete("ABCD"), is(false));
        assertThat(sHashMap.get("Navi"), is("Two"));
    }

    /**
     * Использоване итератора.
     */
    @Test
    public void whenUseIterator() {
        SimpleHashMap<Integer, String> sHashMap = new SimpleHashMap<>(10);
        sHashMap.insert(1, "One");
        sHashMap.insert(2, "Two");
        Iterator iterator = sHashMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("One"));
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Ошибка.
     * Отсутствуют элементы для итерации.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenUseNextForEmptyCollectionThenNoSuchElementException() {
        SimpleHashMap<Integer, String> sHashMap = new SimpleHashMap<>();
        Iterator iterator = sHashMap.iterator();
        iterator.next();
    }

    /**
     * Ошибка.
     * После создания итератора была модифицирована таблица.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenUseNextForModificationCollectionThenConcurrentModificationException() {
        SimpleHashMap<Integer, String> sHashMap = new SimpleHashMap<>();
        Iterator iterator = sHashMap.iterator();
        sHashMap.insert(1, "One");
        iterator.next();
    }
}