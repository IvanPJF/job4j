package ru.job4j.storage.extension;

import ru.job4j.storage.IFood;
import ru.job4j.storage.IStorage;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Decorator to limit the amount of storage.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public class LimitDecorator extends StorageDecorator {

    /**
     * Storage capacity.
     */
    private final int size;

    public LimitDecorator(IStorage storage, int size) {
        super(storage);
        isOverSize(storage, size);
        this.size = size;
    }

    /**
     * Verification of compliance of storage space, and enclosing a volume of food.
     * @param storage Input storage.
     * @param size limitation of space.
     */
    private void isOverSize(IStorage storage, int size) {
        if (storage.getStorage().size() > size) {
            throw new RuntimeException("Is over size");
        }
    }

    /**
     * Checking the occupancy of storage.
     * @return
     */
    private boolean isFullStorage() {
        return this.wrapper.getStorage().size() >= this.size;
    }

    @Override
    public boolean isSuitable(IFood food, LocalDateTime currentDate) {
        return !isFullStorage() && this.wrapper.isSuitable(food, currentDate);
    }

    @Override
    public boolean add(IFood food) {
        return !isFullStorage() && this.wrapper.add(food);
    }

    @Override
    public List<IFood> takeNotSuitable(LocalDateTime currentDate) {
        return this.wrapper.takeNotSuitable(currentDate);
    }

    @Override
    public List<IFood> getStorage() {
        return this.wrapper.getStorage();
    }
}
