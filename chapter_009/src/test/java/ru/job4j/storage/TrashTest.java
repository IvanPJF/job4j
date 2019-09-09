package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrashTest {

    @Test
    public void whenMilkIsExpiredThenMilkRemainsInStorage() {
        LocalDateTime currentDate = LocalDateTime.now();
        IFood milk = new Food("Milk", currentDate.minusWeeks(1), currentDate.minusDays(1), 10, new Discount(50));
        IFood water = new Food("Water", currentDate.minusWeeks(1), currentDate.plusMonths(5), 10, new Discount(50));
        List<IFood> input = new ArrayList<>(Arrays.asList(milk, water));
        Trash storage = new Trash(input);
        List<IFood> expected = new ArrayList<>(Collections.singletonList(water));
        List<IFood> expectedResidue = new ArrayList<>(Collections.singletonList(milk));
        List<IFood> result = storage.takeNotSuitable(currentDate);
        assertThat(result, is(expected));
        assertThat(storage.getStorage(), is(expectedResidue));
    }
}