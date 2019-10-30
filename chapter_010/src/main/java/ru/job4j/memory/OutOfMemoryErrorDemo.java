package ru.job4j.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Heap filling demonstration.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 31.10.2019
 */
public class OutOfMemoryErrorDemo {

    /**
     * Adds items to the list until the heap is full.
     * @throws OutOfMemoryError
     */
    public void fillAllMemory() throws OutOfMemoryError {
        List<Integer> storage = new ArrayList<>();
        Random random = new Random();
        while (true) {
            storage.add(random.nextInt());
        }
    }
}
