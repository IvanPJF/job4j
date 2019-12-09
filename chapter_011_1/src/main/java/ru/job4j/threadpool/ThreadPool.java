package ru.job4j.threadpool;

import ru.job4j.queue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Class thread pool.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 09.12.2019
 */
public class ThreadPool {

    private static final int DEFAULT_SIZE_QUEUE = 4;
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(DEFAULT_SIZE_QUEUE);

    public ThreadPool() {
        startThreads();
    }

    /**
     * Starts threads, the number of which is equal to the number of processor cores.
     * Threads do work from the blocking queue.
     */
    private void startThreads() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        this.tasks.poll().run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            thread.start();
            this.threads.add(thread);
        }
    }

    /**
     * Passes work to the blocking queue.
     * @param job
     */
    public void work(Runnable job) {
        this.tasks.offer(job);
    }

    /**
     * Abort the list of threads created by this object.
     */
    public void shutdown() {
        for (Thread thread : this.threads) {
            thread.interrupt();
        }
    }
}
