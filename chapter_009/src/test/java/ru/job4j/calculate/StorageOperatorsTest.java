package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StorageOperatorsTest {

    @Test
    public void whenUseGetOperationAndExecuteAdd() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        IOperation add = new StorageOperators.AddOperation(calc, "+");
        storage.addOperator(add);
        Double expected = 10.0;
        Double result = storage.getOperation("+").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteSubtract() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        IOperation subtract = new StorageOperators.SubOperation(calc, "-");
        storage.addOperator(subtract);
        Double expected = 6.0;
        Double result = storage.getOperation("-").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteMultiple() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        IOperation multiple = new StorageOperators.MultOperation(calc, "*");
        storage.addOperator(multiple);
        Double expected = 16.0;
        Double result = storage.getOperation("*").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseGetOperationAndExecuteDivision() {
        Calculator calc = new Calculator();
        StorageOperators storage = new StorageOperators();
        IOperation division = new StorageOperators.DivOperation(calc, "/");
        storage.addOperator(division);
        Double expected = 4.0;
        Double result = storage.getOperation("/").execute(8.0, 2.0);
        assertThat(result, is(expected));
    }
}