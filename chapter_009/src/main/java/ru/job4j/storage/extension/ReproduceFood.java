package ru.job4j.storage.extension;

import ru.job4j.storage.IFood;

/**
 * Decorator for food that after the expiration date can be recycled.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public class ReproduceFood extends FoodDecorator {

    public ReproduceFood(IFood wrapper) {
        super(wrapper);
    }

    @Override
    public boolean isReproduce() {
        return true;
    }
}
