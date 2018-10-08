package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void whenValue100AndPrice42() {
        int[] result = new CoffeeMachine().changes(100, 42);
        int[] expect = {10, 10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenValue50AndPrice49() {
        int[] result = new CoffeeMachine().changes(50, 49);
        int[] expect = {1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenValue50AndPrice48() {
        int[] result = new CoffeeMachine().changes(50, 48);
        int[] expect = {2};
        assertThat(result, is(expect));
    }

    @Test
    public void whenValue50AndPrice47() {
        int[] result = new CoffeeMachine().changes(50, 47);
        int[] expect = {2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenValue50AndPrice41() {
        int[] result = new CoffeeMachine().changes(50, 41);
        int[] expect = {5, 2, 2};
        assertThat(result, is(expect));
    }
}
