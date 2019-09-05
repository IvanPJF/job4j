package ru.job4j.storage;

import java.time.LocalDateTime;

/**
 * Food interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public interface IFood {

    /**
     * To obtain the name of the product.
     * @return
     */
    String getName();

    /**
     * Get the product expiration date.
     * @return
     */
    LocalDateTime getExpireDate();

    /**
     * To the date of the creation of the product.
     * @return
     */
    LocalDateTime getCreateDate();

    /**
     * To the price of the product.
     * @return
     */
    Double getPrice();

    /**
     * To obtain the discount of the product.
     * @return
     */
    Discount getDiscount();

    /**
     * To set a discount for a product.
     */
    void sale();
}
