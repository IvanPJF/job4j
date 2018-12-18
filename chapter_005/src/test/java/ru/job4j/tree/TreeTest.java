package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест.
 * Tree.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.12.2018
 *@version 0.1
 */
public class TreeTest {

    /**
     * Поиск элемента.
     * Элемент присутствует в коллекции.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Поиск элемента.
     * Нет такого элемента в коллекции.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Попытка добавить узел с таким значением, которое уже имеется в коллекции.
     * Элемент не будет добавлен.
     */
    @Test
    public void whenAddDoubleElementThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        assertThat(tree.add(3, 2), is(false));
    }

    /**
     * Использование итератора.
     */
    @Test
    public void whenUseIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(3, 5);
        tree.add(5, 6);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }
}