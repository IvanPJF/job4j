package ru.job4j.storage;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract storage.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public abstract class BaseStorage implements IStorage {

    /**
     * The lower threshold of the expiration date.
     */
    private final double fromPercent;

    /**
     * The upper threshold of the expiration date.
     */
    private final double upToPercent;

    private List<IFood> storage;

    public BaseStorage(List<IFood> storage, double fromPercent, double upToPercent) {
        this.storage = storage;
        this.fromPercent = percentToDouble(fromPercent);
        this.upToPercent = percentToDouble(upToPercent);
    }

    /**
     * Bringing the percentage value to the real type.
     * @param percent
     * @return
     */
    private double percentToDouble(Double percent) {
        return percent / 100;
    }

    /**
     * To add food to the storage.
     * @param food
     * @return
     */
    @Override
    public boolean add(IFood food) {
        return this.storage.add(food);
    }

    /**
     * Pick up unsuitable food from storage.
     * @param currentDate
     * @return
     */
    @Override
    public List<IFood> takeNotSuitable(LocalDateTime currentDate) {
        List<IFood> result = new LinkedList<>();
        for (IFood food : this.storage) {
            if (!isSuitable(food, currentDate)) {
                result.add(food);
            }
        }
        this.storage.removeAll(result);
        return result;
    }

    /**
     * Get all storage.
     * @return
     */
    @Override
    public List<IFood> getStorage() {
        return this.storage;
    }

    /**
     * To obtain the lower threshold of the expiration date.
     * @return
     */
    public double getFromPercent() {
        return fromPercent;
    }

    /**
     * To obtain the upper threshold of the expiration date.
     * @return
     */
    public double getUpToPercent() {
        return upToPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseStorage that = (BaseStorage) o;
        return Double.compare(that.fromPercent, fromPercent) == 0
                && Double.compare(that.upToPercent, upToPercent) == 0
                && storage.equals(that.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromPercent, upToPercent, storage);
    }
}
