package ru.job4j.storage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * Warehouse storage.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 05.09.2019
 *@version 0.1
 */
public class Warehouse extends BaseStorage {

    public Warehouse(List<IFood> storage, double fromPercent, double upToPercent) {
        super(storage, fromPercent, upToPercent);
    }

    @Override
    public boolean isSuitable(IFood food, LocalDateTime currentDate) {
        double passedDay = currentDate.getLong(ChronoField.EPOCH_DAY) - food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        double allDay = food.getExpireDate().getLong(ChronoField.EPOCH_DAY) - food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        return passedDay / allDay < this.getUpToPercent();
    }
}
