package ru.job4j.trouble.racecondition;

/**
 * Class race condition demonstration.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class RaceConditionDemo {

    private static final int SIZE = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        Balance balance = new Balance();
        Thread threadPlus = new Thread(new PlusRunnable(balance, SIZE));
        Thread threadMinus = new Thread(new MinusRunnable(balance, SIZE));
        threadPlus.start();
        threadMinus.start();
        threadPlus.join();
        threadMinus.join();
        System.out.printf("%,d", balance.getBalance());
    }
}
