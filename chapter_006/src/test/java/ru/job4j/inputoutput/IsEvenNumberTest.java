package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Чётное число в потоке.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.01.2019
 *@version 0.1
 */
public class IsEvenNumberTest {

    /**
     * Число в потоке чётное.
     */
    @Test
    public void whenNumberInStreamIsEvenThenTrue() {
        IsEvenNumber app = new IsEvenNumber();
        byte[] input = {'2', '4', '8'};
        InputStream stream = new ByteArrayInputStream(input);
        assertThat(app.isNumber(stream), is(true));
    }

    /**
     * Число в потоке не чётное.
     */
    @Test
    public void whenNumberInStreamIsNotEvenThenFalse() {
        IsEvenNumber app = new IsEvenNumber();
        byte[] input = {'2', '4', '8', '5'};
        InputStream stream = new ByteArrayInputStream(input);
        assertThat(app.isNumber(stream), is(false));
    }

    /**
     * Символы в потоке не являются числом.
     */
    @Test
    public void whenSymbolsInStreamIsNotNumberThenFalse() {
        IsEvenNumber app = new IsEvenNumber();
        byte[] input = {'w', 'o', 'r', 'd'};
        InputStream stream = new ByteArrayInputStream(input);
        assertThat(app.isNumber(stream), is(false));
    }

    /**
     * Невозможно прочитать файл с таким адресом.
     */
    @Test(expected = IOException.class)
    public void whenFileNotFoundThenException() throws FileNotFoundException {
        new IsEvenNumber().isNumber(new FileInputStream("ccc:\\File.txt"));
    }
}