package ru.job4j.ref;

/**
 * Cache interface.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 19.10.2019
 */
public interface ICache<K, V> {

    /**
     * Get value from cache by key.
     *
     * @param key
     * @return
     */
    V getValue(K key);
}
