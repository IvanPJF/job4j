package ru.job4j.storage;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Storage interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public interface IStorage {

    /**
     * Compliance with food storage.
     * @param food
     * @param currentDate
     * @return
     */
    boolean isSuitable(IFood food, LocalDateTime currentDate);

    /**
     * To add food to the storage.
     * @param food
     * @return
     */
    boolean add(IFood food);

    /**
     * Pick up unsuitable food from storage.
     * @param currentDate
     * @return
     */
    List<IFood> takeNotSuitable(LocalDateTime currentDate);

    /**
     * Get all storage.
     * @return
     */
    List<IFood> getStorage();

    List<IFood> takeAllFood();
}
