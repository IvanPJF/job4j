package ru.job4j.storage;

import java.util.Objects;

/**
 * Class user.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 27.11.2019
 */
public class User implements IUser {

    private final int id;
    private int amount;

    public User(final int id, final int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Get id user.
     *
     * @return
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Get user amount.
     *
     * @return
     */
    @Override
    public int getAmount() {
        return this.amount;
    }

    /**
     * Reduce user amount.
     *
     * @param value The value by which you need to reduce the amount.
     */
    @Override
    public void minus(int value) {
        this.amount -= value;
    }

    /**
     * Increase user amount.
     *
     * @param value The value by which you need to increase the amount.
     */
    @Override
    public void plus(int value) {
        this.amount += value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && amount == user.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}
