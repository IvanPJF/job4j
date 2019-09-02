package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StorageOperatorsTest {

    @Test
    public void whenUseGetOperationAndExecuteAdd() {
        StorageOperators so = new StorageOperators(new Calculator());
        Double expected = 10.0;
        Double result = so.getOperation("+").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteSubtract() {
        StorageOperators so = new StorageOperators(new Calculator());
        Double expected = 6.0;
        Double result = so.getOperation("-").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteMultiple() {
        StorageOperators so = new StorageOperators(new Calculator());
        Double expected = 16.0;
        Double result = so.getOperation("*").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteDivision() {
        StorageOperators so = new StorageOperators(new Calculator());
        Double expected = 4.0;
        Double result = so.getOperation("/").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }
}