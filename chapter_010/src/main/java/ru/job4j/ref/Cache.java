package ru.job4j.ref;

/**
 * Class cache.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 19.10.2019
 */
public class Cache<K, V> {

    private ICache<K, V> cache;

    public Cache(ICache<K, V> cache) {
        this.cache = cache;
    }

    public V getValue(K key) {
        return cache.getValue(key);
    }

    public void setCache(ICache<K, V> newCache) {
        cache = newCache;
    }
}
