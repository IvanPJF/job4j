package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 * The class for the configurations.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.04.2019
 *@version 0.1
 */
public class ConfigTest {

    /**
     * File creation. Write to this information file.
     * @param fileName File name.
     * @param properties Text information to write to a file.
     * @return A link to the created file.
     * @throws IOException
     */
    public File data(String fileName, String... properties) throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir"), fileName);
        if (!file.createNewFile()) {
            throw new IllegalStateException(String.format("File could not created %s", file.getAbsoluteFile()));
        }
        try (PrintWriter write = new PrintWriter(file)) {
            Stream.of(properties).forEach(write::println);
        }
        return file;
    }

    /**
     * Getting a key value from properties.
     * @throws IOException
     */
    @Test
    public void whenUseConfigValue() throws IOException {
        File path = this.data(
                String.valueOf(System.currentTimeMillis()),
                "user=ivanpjf"
        );
        Config config = new Config(path.getAbsolutePath()).load();
        assertThat(config.value("user"), is("ivanpjf"));
        path.deleteOnExit();
    }

    /**
     * Take all the information from the file.
     * @throws IOException
     */
    @Test
    public void whenReadAllFile() throws IOException {
        File path = this.data(
                String.valueOf(System.currentTimeMillis()),
                "## Information",
                "user=ivanpjf",
                "password=pass"
        );
        Config config = new Config(path.getAbsolutePath()).load();
        StringJoiner expected = new StringJoiner(System.lineSeparator())
                .add("## Information")
                .add("user=ivanpjf")
                .add("password=pass");
        assertThat(config.toString(), is(expected.toString()));
        path.deleteOnExit();
    }
}