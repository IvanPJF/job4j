package ru.job4j.email;

/**
 * User interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 10.12.2019
 */
public interface IUser {

    /**
     * Gets the username.
     *
     * @return
     */
    String getUserName();

    /**
     * Gets the user email.
     *
     * @return
     */
    String getEmail();
}
