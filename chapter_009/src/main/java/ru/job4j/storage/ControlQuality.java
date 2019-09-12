package ru.job4j.storage;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Control quality.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public class ControlQuality {

    private final List<IStorage> storages;

    public ControlQuality(List<IStorage> storages) {
        this.storages = storages;
    }

    /**
     * Add storage.
     * @param storage
     */
    public void addStorage(IStorage storage) {
        this.storages.add(storage);
    }

    /**
     * Find out which storage can get food.
     * @param food
     * @param currentDate
     * @return The storage to which the food corresponds.
     */
    public IStorage defineStorage(IFood food, LocalDateTime currentDate) {
        IStorage result = null;
        for (IStorage storage : this.storages) {
            if (storage.isSuitable(food, currentDate)) {
                result = storage;
                break;
            }
        }
        return result;
    }

    /**
     * Insert food into one of the storage.
     * @param food
     * @param currentDate
     * @return The storage where the food is sent.
     */
    public IStorage put(IFood food, LocalDateTime currentDate) {
        IStorage storage = defineStorage(food, currentDate);
        storage.add(food);
        return storage;
    }

    /**
     * To get all storage.
     * @return
     */
    public List<IStorage> getStorages() {
        return this.storages;
    }

    public void resort(LocalDateTime currentDate) {
        List<IFood> allFoods = new LinkedList<>();
        for (IStorage storage : this.storages) {
            allFoods.addAll(storage.takeNotSuitable(currentDate));
        }
        for (IFood food : allFoods) {
            put(food, currentDate);
        }
    }
}
