package ru.job4j.storage.extension;

import ru.job4j.storage.IFood;
import ru.job4j.storage.Trash;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Storage for processing expired food.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public class ReproduceTrash extends Trash {

    public ReproduceTrash(List<IFood> storage) {
        super(storage);
    }

    @Override
    public boolean isSuitable(IFood food, LocalDateTime currentDate) {
        return food.isReproduce() && super.isSuitable(food, currentDate);
    }
}
