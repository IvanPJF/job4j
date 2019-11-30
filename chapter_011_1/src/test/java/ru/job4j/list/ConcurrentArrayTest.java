package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConcurrentArrayTest {

    @Test
    public void whenInOneThreadGetIteratorAndInTwoThreadAddElementThenIteratorNotContainsNewElement() throws InterruptedException {
        final DynamicArray<Integer> dynArray = new DynamicArray<>(1);
        dynArray.add(1);
        ConcurrentArray<Integer> array = new ConcurrentArray<>(dynArray);
        Iterator<Integer> iterFirst = array.iterator();
        Runnable addRunnable = () -> dynArray.add(2);
        Thread thread = new Thread(addRunnable);
        thread.start();
        thread.join();
        Iterator<Integer> iterSecond = array.iterator();
        assertThat(iterFirst.hasNext(), is(true));
        assertThat(iterFirst.next(), is(1));
        assertThat(iterFirst.hasNext(), is(false));
        assertThat(iterSecond.next(), is(1));
        assertThat(iterSecond.next(), is(2));
        assertThat(iterSecond.hasNext(), is(false));
    }
}