package ru.job4j.generic.store;

/**
 * Абстрактный класс для моделей.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.11.2018
 *@version 0.1
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}