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

public class ReproduceTrashTest {

    @Test
    public void whenFoodIsReproducedAndTrashThenTrue() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood bread = new ReproduceFood(new Food("Bread", currentDate.minusDays(9), currentDate.minusDays(1), 10, new Discount(50)));
        IStorage storage = new ReproduceTrash(new ArrayList<>());
        boolean result = storage.isSuitable(bread, currentDate);
        assertThat(result, is(true));
    }

    @Test
    public void whenFoodIsNotReproducedAndTrashThenFalse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood bread = new Food("Bread", currentDate.minusDays(9), currentDate.minusDays(1), 10, new Discount(50));
        IStorage storage = new ReproduceTrash(new ArrayList<>());
        boolean result = storage.isSuitable(bread, currentDate);
        assertThat(result, is(false));
    }

    @Test
    public void whenFoodIsReproducedAndNewThenFalse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood bread = new ReproduceFood(new Food("Bread", currentDate.minusDays(1), currentDate.plusDays(9), 10, new Discount(50)));
        IStorage storage = new ReproduceTrash(new ArrayList<>());
        boolean result = storage.isSuitable(bread, currentDate);
        assertThat(result, is(false));
    }
}