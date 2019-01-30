package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Удаление запрещённых слов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.01.2019
 *@version 0.1
 */
public class WordFilterTest {

    /**
     * Получает поток с запрещёнными словами, выводит поток без запрещённых слов.
     */
    @Test
    public void whenDeleteAbuseWord() {
        WordFilter wordFilter = new WordFilter();
        String[] abuse = {"one", "two", "three"};
        String newLine = System.lineSeparator();
        String input = "one two three four"
                + newLine + "five six"
                + newLine;
        String expected = "four "
                + newLine + "five six "
                + newLine;
        Reader reader = new StringReader(input);
        Writer writer = new StringWriter();
        wordFilter.dropAbuses(reader, writer, abuse);
        String result = writer.toString();
        assertThat(result, is(expected));
    }

    /**
     * Невозможно прочитать или записать файл с таким адресом.
     */
    @Test(expected = IOException.class)
    public void whenFileNotFoundThenException() throws IOException {
        new WordFilter().dropAbuses(
                new FileReader("File.txt"),
                new FileWriter("File1.txt"),
                new String[]{});
    }
}