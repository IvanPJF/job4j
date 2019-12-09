package ru.job4j.threadpool;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ThreadPoolTest {

    @Test
    public void whenAddMoreWorkThenWorkExecuteInManyThreads() throws InterruptedException {
        final AtomicInteger inc = new AtomicInteger(0);
        final ThreadPool pool = new ThreadPool();
        int expected = 100;
        for (int i = 0; i < expected; i++) {
            pool.work(() -> {
                int value = 0;
                do {
                    value = inc.get();
                } while (!inc.compareAndSet(value, value + 1));
            });
        }
        Thread.sleep(expected * 10);
        pool.shutdown();
        assertThat(inc.get(), is(expected));
    }
}