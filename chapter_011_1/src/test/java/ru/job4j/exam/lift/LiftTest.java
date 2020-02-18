package ru.job4j.exam.lift;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LiftTest {

    @Test
    public void whenLiftTarget3FloorThenAfter2StepIsFinishTrue() {
        Lift lift = new Lift(1);
        int targetFloor = 3;
        lift.targetFloor(targetFloor);
        lift.step();
        lift.step();
        assertThat(lift.isFinish(), is(true));
    }
}