package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShopTest {

    @Test
    public void whenAddFoodToStorageThenStorageContainIt() {
        LocalDateTime currentDate = LocalDateTime.now();
        Shop storage = new Shop(new ArrayList<>(), 25, 75);
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        storage.add(milk);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> result = storage.getStorage();
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseTakeNotSuitableThenGetWater() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(1), currentDate.plusMonths(5), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        Shop storage = new Shop(input, 25, 75);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(water));
        List<IFood> expectedResidue = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> result = storage.takeNotSuitable(currentDate);
        assertThat(result, is(expected));
        assertThat(storage.getStorage(), is(expectedResidue));
    }

    @Test
    public void whenUseTakeNotSuitableThenPriceMilkIs50PercentLess() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(5), currentDate.plusWeeks(1), 10, new Discount(50));
        IFood milkWithPercent = new Food("Milk", currentDate.minusWeeks(5), currentDate.plusWeeks(1), 5, new Discount(50, true));
        List<IFood> input = new ArrayList<>(Collections.singletonList(milk));
        Shop storage = new Shop(input, 25, 75);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milkWithPercent));
        storage.takeNotSuitable(currentDate);
        List<IFood> result = storage.getStorage();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoodIsExpiredThenTakeNotSuitableReturnMilk() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.minusDays(1), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusMonths(5), currentDate.plusMonths(5), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        Shop storage = new Shop(input, 25, 75);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> expectedResidue = new ArrayList<>(Collections.singletonList(water));
        List<IFood> result = storage.takeNotSuitable(currentDate);
        assertThat(result, is(expected));
        assertThat(storage.getStorage(), is(expectedResidue));
    }
}