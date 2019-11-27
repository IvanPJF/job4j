package ru.job4j.multiincrement;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountTest {

    private class ThreadCount extends Thread {

        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            count.increment();
        }
    }

    @Test
    public void whenStart2ThreadThenCountIs2() throws InterruptedException {
        final Count count = new Count();
        Thread threadFirst = new ThreadCount(count);
        Thread threadSecond = new ThreadCount(count);
        threadFirst.start();
        threadSecond.start();
        threadFirst.join();
        threadSecond.join();
        assertThat(count.get(), is(2));
    }
}