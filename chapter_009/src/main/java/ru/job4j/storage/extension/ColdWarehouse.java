package ru.job4j.storage.extension;

import ru.job4j.storage.IFood;
import ru.job4j.storage.Warehouse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Warehouse for cold-loving foods.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public class ColdWarehouse extends Warehouse {

    public ColdWarehouse(List<IFood> storage, double fromPercent, double upToPercent) {
        super(storage, fromPercent, upToPercent);
    }

    @Override
    public boolean isSuitable(IFood food, LocalDateTime currentDate) {
        return food.isCold() && super.isSuitable(food, currentDate);
    }
}
