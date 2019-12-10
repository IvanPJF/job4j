package ru.job4j.email;

/**
 * Class user.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 10.12.2019
 */
public class User implements IUser {

    private String userName;
    private String email;

    public User(final String userName, final String email) {
        this.userName = userName;
        this.email = email;
    }

    /**
     * Gets the username.
     *
     * @return
     */
    @Override
    public String getUserName() {
        return this.userName;
    }

    /**
     * Gets the user email.
     *
     * @return
     */
    @Override
    public String getEmail() {
        return this.email;
    }
}
