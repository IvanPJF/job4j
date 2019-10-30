package ru.job4j.memory;

import org.junit.Test;

public class OutOfMemoryErrorDemoTest {

    @Test(expected = OutOfMemoryError.class)
    public void whenHeapIsFullThenOutOfMemoryError() {
        new OutOfMemoryErrorDemo().fillAllMemory();
    }
}