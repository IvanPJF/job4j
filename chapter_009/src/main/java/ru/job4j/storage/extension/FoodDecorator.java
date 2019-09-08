package ru.job4j.storage.extension;

import ru.job4j.storage.Discount;
import ru.job4j.storage.IFood;

import java.time.LocalDateTime;

/**
 * Abstract class decorator for food.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2019
 *@version 0.1
 */
public abstract class FoodDecorator implements IFood {

    protected final IFood wrapper;

    public FoodDecorator(IFood wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String getName() {
        return wrapper.getName();
    }

    @Override
    public LocalDateTime getExpireDate() {
        return wrapper.getExpireDate();
    }

    @Override
    public LocalDateTime getCreateDate() {
        return wrapper.getCreateDate();
    }

    @Override
    public Double getPrice() {
        return wrapper.getPrice();
    }

    @Override
    public Discount getDiscount() {
        return wrapper.getDiscount();
    }

    @Override
    public void sale() {
        wrapper.sale();
    }
}
