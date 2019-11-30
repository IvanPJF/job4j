package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * Class concurrent array.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.11.2019
 */
@ThreadSafe
public class ConcurrentArray<E> implements Iterable<E> {

    @GuardedBy("this")
    private final DynamicArray<E> array;

    public ConcurrentArray(final DynamicArray<E> array) {
        this.array = array;
    }

    /**
     * Adds a new item to the collection.
     * @param value
     */
    public synchronized void add(E value) {
        this.array.add(value);
    }

    /**
     * Gets the item from the collection by index.
     * @param index
     * @return
     */
    public synchronized E get(int index) {
        return this.array.get(index);
    }

    /**
     * Gets the size of the collection.
     * @return
     */
    public synchronized int getSize() {
        return this.array.getSize();
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.array).iterator();
    }

    /**
     * Copies an internal collection for an iterator.
     * @param array
     * @return
     */
    private synchronized DynamicArray<E> copy(DynamicArray<E> array) {
        DynamicArray<E> copyArr = new DynamicArray<>(this.array.getSize());
        for (E elem : this.array) {
            copyArr.add(elem);
        }
        return copyArr;
    }
}
