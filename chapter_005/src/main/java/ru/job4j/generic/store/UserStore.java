package ru.job4j.generic.store;

/**
 * Контейнер для хранения элементов типа User.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.11.2018
 *@version 0.1
 */
public class UserStore<User extends Base> extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}
