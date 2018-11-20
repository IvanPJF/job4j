package ru.job4j.generic.store;

/**
 * Контейнер для хранения элементов типа Role.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.11.2018
 *@version 0.1
 */
public class RoleStore<Role extends Base> extends AbstractStore<Role> {

    public RoleStore(int size) {
        super(size);
    }
}
