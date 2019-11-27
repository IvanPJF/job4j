package ru.job4j.storage;

/**
 * User interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 27.11.2019
 */
public interface IUser {

    /**
     * Get id user.
     *
     * @return
     */
    int getId();

    /**
     * Get user amount.
     *
     * @return
     */
    int getAmount();

    /**
     * Increase user amount.
     *
     * @param value The value by which you need to increase the amount.
     */
    void plus(int value);

    /**
     * Reduce user amount.
     *
     * @param value The value by which you need to reduce the amount.
     */
    void minus(int value);
}
