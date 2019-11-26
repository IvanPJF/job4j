package ru.job4j.trouble.racecondition;

/**
 * Class balance.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class Balance {

    private int balance;

    public void plus() {
        balance++;
    }

    public void minus() {
        balance--;
    }

    public int getBalance() {
        return balance;
    }
}