package ru.job4j.trouble.deadlock;

/**
 * Class deadlock demonstration.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        IResource resourceA = new Resource(1);
        IResource resourceB = new Resource(1);
        resourceA.setResource(resourceB);
        resourceB.setResource(resourceA);
        Thread threadFirst = new Thread(new PrintRunnable(resourceA));
        Thread threadSecond = new Thread(new PrintRunnable(resourceB));
        threadFirst.start();
        threadSecond.start();
    }
}
