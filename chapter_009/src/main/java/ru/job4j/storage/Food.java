package ru.job4j.storage;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Food class.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public class Food implements IFood {

    private String name;
    private LocalDateTime expireDate;
    private LocalDateTime createDate;
    private double price;
    private Discount discount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expireDate, double price, Discount discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public void sale() {
        this.price *= this.discount.use();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && name.equals(food.name)
                && expireDate.equals(food.expireDate)
                && createDate.equals(food.createDate)
                && discount.equals(food.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }
}
