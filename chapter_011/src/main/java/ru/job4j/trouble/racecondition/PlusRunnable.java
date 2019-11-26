package ru.job4j.trouble.racecondition;

/**
 * Class increase out of balance.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class PlusRunnable implements Runnable {
    private Balance balance;
    private int size;

    public PlusRunnable(Balance balance, int size) {
        this.balance = balance;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            balance.plus();
        }
    }
}
