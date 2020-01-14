package ru.job4j.bomberman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HeroTest {

    @Test
    public void whenCreateMonsterThenCell00() {
        Hero hero = new Hero();
        assertThat(hero.getPosition(), is(new Cell(0, 0)));
    }

    @Test
    public void whenSetPositionCell22ThenGetPositionCell22() {
        Hero hero = new Hero();
        hero.setPosition(new Cell(2, 2));
        assertThat(hero.getPosition(), is(new Cell(2, 2)));
    }

    @Test
    public void whenStepToRightThenNewPositionGetXOneMore() {
        Hero hero = new Hero();
        Cell oldPosition = hero.getPosition();
        Cell newPosition = hero.step(Way.RIGHT);
        assertThat(newPosition.getX(), is(oldPosition.getX() + 1));
        assertThat(newPosition.getY(), is(oldPosition.getY()));
    }

    @Test
    public void whenCreateNewInstanceThenPositionsEquals() {
        IHero hero = new Hero();
        IHero newInstance = hero.createNewInstance();
        assertThat(hero.getPosition(), is(newInstance.getPosition()));
    }
}