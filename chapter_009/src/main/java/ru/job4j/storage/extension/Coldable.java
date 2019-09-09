package ru.job4j.storage.extension;

/**
 * The interface for the food to be placed in a cold warehouse.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public interface Coldable {

    /**
     * The default value is false.
     * @return false.
     */
    default boolean isCold() {
        return false;
    }
}
