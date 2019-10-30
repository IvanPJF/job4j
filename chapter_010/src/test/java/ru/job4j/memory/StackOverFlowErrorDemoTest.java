package ru.job4j.memory;

import org.junit.Test;

public class StackOverFlowErrorDemoTest {

    @Test(expected = StackOverflowError.class)
    public void whenStackIsFullThenStackOverflowError() {
        new StackOverFlowErrorDemo().addMethodToStack();
    }
}