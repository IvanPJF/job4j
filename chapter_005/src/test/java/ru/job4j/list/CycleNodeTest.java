package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Цикличность связанног списка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.11.2018
 *@version 0.1
 */
public class CycleNodeTest {

    /**
     * Список не цикличен.
     */
    @Test
    public void whenLinkedListIsNotCycleThenFalse() {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        assertThat(new CycleNode().hasCycle(one), is(false));
    }

    /**
     * Список цикличен.
     */
    @Test
    public void whenLinkedListIsCycleThenTrue() {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        one.next = two;
        two.next = three;
        three.next = one;
        assertThat(new CycleNode().hasCycle(one), is(true));
    }
}