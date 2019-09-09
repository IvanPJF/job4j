package ru.job4j.storage.extension;

import ru.job4j.storage.IFood;

/**
 * Decorator for cold-loving foods.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public class ColdFood extends FoodDecorator {

    public ColdFood(IFood wrapper) {
        super(wrapper);
    }

    @Override
    public boolean isCold() {
        return true;
    }
}
