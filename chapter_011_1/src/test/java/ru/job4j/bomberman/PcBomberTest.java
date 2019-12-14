package ru.job4j.bomberman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PcBomberTest {

    @Test
    public void whenCreateBomberManThenCell00() {
        PcBomber bomber = new PcBomber();
        assertThat(bomber.getPosition(), is(new Cell(0, 0)));
    }

    @Test
    public void whenSetPositionCell22ThenGetPositionCell22() {
        PcBomber bomber = new PcBomber();
        bomber.setPosition(new Cell(2, 2));
        assertThat(bomber.getPosition(), is(new Cell(2, 2)));
    }
}