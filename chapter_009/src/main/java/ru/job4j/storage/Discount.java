package ru.job4j.storage;

import java.util.Objects;

/**
 * Discount class.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public class Discount {

    private final double value;
    private boolean enabled;

    public Discount(double percent, boolean enabled) {
        this.value = percentToDouble(percent);
        this.enabled = enabled;
    }

    public Discount(double percent) {
        this.value = percentToDouble(percent);
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
     * Activity discounts.
     * @return
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * The use of discounts.
     * @return
     */
    public double use() {
        this.enabled = true;
        return this.value;
    }

    /**
     * Find out the size of the discount.
     * @return
     */
    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Discount discount = (Discount) o;
        return Double.compare(discount.value, value) == 0
                && enabled == discount.enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, enabled);
    }
}
