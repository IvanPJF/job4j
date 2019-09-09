package ru.job4j.storage.extension;

import org.junit.Test;
import ru.job4j.storage.Discount;
import ru.job4j.storage.Food;
import ru.job4j.storage.IFood;
import ru.job4j.storage.IStorage;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColdWarehouseTest {

    @Test
    public void whenFoodIsColdAndNewThenTrue() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood potato = new ColdFood(new Food("Potato", currentDate.minusMonths(1), currentDate.plusMonths(9), 10, new Discount(50)));
        IStorage storage = new ColdWarehouse(new ArrayList<>(), 0, 25);
        boolean result = storage.isSuitable(potato, currentDate);
        assertThat(result, is(true));
    }

    @Test
    public void whenFoodIsNotColdAndNewThenFalse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood bread = new Food("Bread", currentDate.minusDays(1), currentDate.plusDays(9), 10, new Discount(50));
        IStorage storage = new ColdWarehouse(new ArrayList<>(), 0, 25);
        boolean result = storage.isSuitable(bread, currentDate);
        assertThat(result, is(false));
    }

    @Test
    public void whenFoodIsColdAndOldThenFalse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood potato = new ColdFood(new Food("Potato", currentDate.minusMonths(9), currentDate.plusMonths(1), 10, new Discount(50)));
        IStorage storage = new ColdWarehouse(new ArrayList<>(), 0, 25);
        boolean result = storage.isSuitable(potato, currentDate);
        assertThat(result, is(false));
    }
}