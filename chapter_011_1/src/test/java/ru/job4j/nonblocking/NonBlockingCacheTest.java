package ru.job4j.nonblocking;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NonBlockingCacheTest {

    @Test
    public void whenAddBaseThenCacheContainsOneBase() {
        final NonBlockingCache cache = new NonBlockingCache();
        cache.add(new Base(1, "First"));
        assertThat(cache.getById(1), is(new Base(1, "First")));
    }

    @Test
    public void whenChangeBaseInTwoThreadThenOptimisticException() throws InterruptedException {
        final NonBlockingCache cache = new NonBlockingCache();
        AtomicReference<Exception> exception = new AtomicReference<>();
        int size = 500;
        for (int i = 0; i < size; i++) {
            cache.add(new Base(i, "Main"));
        }
        Thread threadFirst = new Thread(
                () -> {
                    for (int i = 0; i < size; i++) {
                        Base base = cache.getById(i);
                        base.setName(String.format("%s, First", base.getName()));
                        try {
                            cache.update(base);
                        } catch (OptimisticException oe) {
                            exception.set(oe);
                        }
                    }
                }
        );
        Thread threadSecond = new Thread(
                () -> {
                    for (int i = 0; i < size; i++) {
                        Base base = cache.getById(i);
                        base.setName(String.format("%s, Second", base.getName()));
                        try {
                            cache.update(base);
                        } catch (OptimisticException oe) {
                            exception.set(oe);
                        }
                    }
                }
        );
        threadFirst.start();
        threadSecond.start();
        threadFirst.join();
        threadSecond.join();
        assertThat(exception.get().getMessage(), is("The model version has been changed in another thread."));
    }
}