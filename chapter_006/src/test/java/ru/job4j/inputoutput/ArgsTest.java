package ru.job4j.inputoutput;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {

    @Test
    public void whenParserIsValid() {
        String[] arrString = new String[]{"-d", "123/456/789", "-e", "txt", "-o", "out.zip"};
        Args args = new Args(arrString);
        assertThat(args.directory(), is("123/456/789"));
        assertThat(args.output(), is("out.zip"));
    }
}