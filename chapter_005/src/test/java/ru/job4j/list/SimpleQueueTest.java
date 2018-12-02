package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Stack.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 29.11.2018
 *@version 0.1
 */
public class SimpleQueueTest {

    /**
     * Добавление элементов в очередь.
     */
    @Test
    public void whenUsePush() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.getSize(), is(3));
    }

    /**
     * Взять один элемент из очереди, когда она содержит элементы.
     */
    @Test
    public void whenUsePollThenResultIsOneAndSizeTwo() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.getSize(), is(2));
    }

    /**
     * Взять один элемент из очереди, когда в ней нет элементов.
     */
    @Test
    public void whenUsePollThenResultIsNull() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        assertThat(simpleQueue.poll(), is((Integer) null));
    }

    @Test
    public void whenUseTwoTimesPushAndPollAndOneTimesPushAndPoll() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        Integer resultFirst = simpleQueue.poll();
        simpleQueue.push(3);
        Integer resultSecond = simpleQueue.poll();
        assertThat(resultFirst, is(1));
        assertThat(resultSecond, is(2));
    }
}