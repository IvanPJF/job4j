package ru.job4j.exam;

import java.util.concurrent.CountDownLatch;

/**
 * Class for create guaranteed deadlock.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 23.01.2020
 */
public class GuaranteedDeadlock {

    private final CountDownLatch latch = new CountDownLatch(2);
    private final Object objectOne = new Object();
    private final Object objectTwo = new Object();

    /**
     * Run a deadlock situation.
     */
    public void runDeadLock() {
        new ThreadLock(this.objectOne, this.objectTwo).start();
        new ThreadLock(this.objectTwo, this.objectOne).start();
    }

    class ThreadLock extends Thread {

        private final Object objectOne;
        private final Object objectTwo;

        ThreadLock(Object objOne, Object objTwo) {
            this.objectOne = objOne;
            this.objectTwo = objTwo;
        }

        @Override
        public void run() {
            synchronized (objectOne) {
                latch.countDown();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectTwo) {
                    System.out.printf("Thread #%d is dead", this.getId());
                }
            }
        }
    }
}
