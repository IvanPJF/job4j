package ru.job4j.storage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * Shop storage.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public class Shop extends BaseStorage {

    public Shop(List<IFood> storage, double fromPercent, double upToPercent) {
        super(storage, fromPercent, upToPercent);
    }

    @Override
    public boolean isSuitable(IFood food, LocalDateTime currentDate) {
        double passedDay = currentDate.getLong(ChronoField.EPOCH_DAY) - food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        double allDay = food.getExpireDate().getLong(ChronoField.EPOCH_DAY) - food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        double percent = passedDay / allDay;
        return percent >= this.getFromPercent() && percent <= this.getUpToPercent()
                || discount(food, percent);
    }

    /**
     * To assign a discount for old food.
     * @param food
     * @param percent
     * @return True - when food is old,
     * False - in other cases.
     */
    private boolean discount(IFood food, double percent) {
        boolean result = false;
        if (percent > this.getUpToPercent() && percent < 1.0) {
            if (!food.getDiscount().isEnabled()) {
                food.sale();
            }
            result = true;
        }
        return result;
    }
}
