package ru.job4j.multiincrement;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class count.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 27.11.2019
 */
@ThreadSafe
public class Count {

    @GuardedBy("this")
    private int value;

    /**
     * Increment counter value by 1.
     * The method can be used at one time by only one thread.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Get the value of the counter.
     * The method can be used at one time by only one thread.
     * @return Counter value.
     */
    public synchronized int get() {
        return this.value;
    }
}
