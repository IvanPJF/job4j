package ru.job4j.queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class blocking queue.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 04.12.2019
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private final int fillSize;

    public SimpleBlockingQueue(final int fillSize) {
        this.fillSize = fillSize;
    }

    /**
     * Gets an item from a blocking queue.
     *
     * @return
     */
    public synchronized T poll() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait();
        }
        T elem = this.queue.poll();
        notify();
        return elem;
    }

    /**
     * Inserts an item into a blocking queue.
     *
     * @param value
     */
    public synchronized void offer(T value) {
        while (this.queue.size() >= this.fillSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.offer(value);
        notify();
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
