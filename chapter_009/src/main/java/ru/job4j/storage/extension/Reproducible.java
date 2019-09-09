package ru.job4j.storage.extension;

/**
 * Interface for food that can be recycled after the expiration date.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public interface Reproducible {

    /**
     * The default value is false.
     * @return false.
     */
    default boolean isReproduce() {
        return false;
    }
}
