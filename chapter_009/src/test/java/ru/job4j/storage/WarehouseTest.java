package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WarehouseTest {

    @Test
    public void whenAddFoodToStorageThenStorageContainIt() {
        LocalDateTime currentDate = LocalDateTime.now();
        Warehouse storage = new Warehouse(new ArrayList<>(), 0, 25);
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        storage.add(milk);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> result = storage.getStorage();
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseTakeNotSuitableThenGetMilk() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(1), currentDate.plusMonths(5), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        Warehouse storage = new Warehouse(input, 0, 25);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> expectedResidue = new ArrayList<>(Collections.singletonList(water));
        List<IFood> result = storage.takeNotSuitable(currentDate);
        assertThat(result, is(expected));
        assertThat(storage.getStorage(), is(expectedResidue));
    }
}