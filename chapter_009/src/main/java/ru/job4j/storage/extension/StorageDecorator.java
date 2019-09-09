package ru.job4j.storage.extension;

import ru.job4j.storage.IStorage;

/**
 * Abstract class decorator for storage.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public abstract class StorageDecorator implements IStorage {

    protected final IStorage wrapper;

    public StorageDecorator(IStorage storage) {
        this.wrapper = storage;
    }
}
