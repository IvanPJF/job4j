package ru.job4j.generator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleGeneratorTest {

    @Test
    public void whenOneKeyAndOneValueThenHelloWorld() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first}!";
        String[] value = {"World"};
        String result = generator.generate(text, value);
        String expected = "Hello, World!";
        assertThat(result, is(expected));
    }

    @Test
    public void whenRepeatOneKeyAndOneValueThenHelloWorldWorld() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first} ${first}!";
        String[] value = {"World"};
        String result = generator.generate(text, value);
        String expected = "Hello, World World!";
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoKeyAndTwoValueThenHelloBeautifulWorld() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first} ${second}!";
        String[] value = {"beautiful", "World"};
        String result = generator.generate(text, value);
        String expected = "Hello, beautiful World!";
        assertThat(result, is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenManyKeyThenException() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first} ${second}!";
        String[] value = {"World"};
        String result = generator.generate(text, value);
    }

    @Test(expected = RuntimeException.class)
    public void whenNotValueThenException() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first}!";
        String[] value = {};
        String result = generator.generate(text, value);
    }

    @Test(expected = RuntimeException.class)
    public void whenNotEnoughKeysThenException() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello, ${first} ${first} ${second}!";
        String[] value = {"my", "beautiful", "World"};
        String result = generator.generate(text, value);
    }

    @Test(expected = RuntimeException.class)
    public void whenNotKeysThenException() {
        IGenerator generator = new SimpleGenerator();
        String text = "Hello!";
        String[] value = {"World"};
        String result = generator.generate(text, value);
    }
}