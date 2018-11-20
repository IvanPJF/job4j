package ru.job4j.generic.store;

/**
 * Интерфейс.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.11.2018
 *@version 0.1
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
