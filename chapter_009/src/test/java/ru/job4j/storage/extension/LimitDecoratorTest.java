package ru.job4j.storage.extension;

import org.junit.Test;
import ru.job4j.storage.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LimitDecoratorTest {

    @Test
    public void whenSizeStorageIsOneThenStorageContainOnlyMilk() {
        LocalDateTime currentDate = LocalDateTime.now();
        Warehouse storage = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage storageLimit = new LimitDecorator(storage, 1);
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(1), currentDate.plusWeeks(1), 10, new Discount(50));
        storageLimit.add(milk);
        storageLimit.add(water);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> result = storage.getStorage();
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseIsSuitableAndStorageIsNotFullThenTrue() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(9), 10, new Discount(50));
        IStorage storage = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage storageLimit = new LimitDecorator(storage, 1);
        boolean result = storageLimit.isSuitable(milk, currentDate);
        assertThat(result, is(true));
    }

    @Test
    public void whenUseIsSuitableAndStorageIsFullThenFalse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(9), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(1), currentDate.plusWeeks(9), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Collections.singletonList(milk));
        IStorage storage = new Warehouse(input, 0, 25);
        IStorage storageLimit = new LimitDecorator(storage, 1);
        boolean result = storageLimit.isSuitable(water, currentDate);
        assertThat(result, is(false));
    }

    @Test
    public void whenUseTakeNotSuitableThenGetWater() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(9), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(9), currentDate.plusWeeks(1), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        IStorage storage = new Warehouse(input, 0, 25);
        IStorage storageLimit = new LimitDecorator(storage, 2);
        List<IFood> result = storageLimit.takeNotSuitable(currentDate);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(water));
        assertThat(result, is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenInputOverSizeStorageThenException() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.plusWeeks(9), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(9), currentDate.plusWeeks(1), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        IStorage storage = new Warehouse(input, 0, 25);
        new LimitDecorator(storage, 1);
    }
}