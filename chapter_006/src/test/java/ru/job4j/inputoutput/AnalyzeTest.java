package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.*;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 * Server operation analysis.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.04.2019
 *@version 0.1
 */
public class AnalyzeTest {

    /**
     * Create log file.
     * @param nameFile Log file name.
     * @param textLog The contents of the log file.
     * @return Log file reference.
     * @throws IOException
     */
    public File createLogFile(String nameFile, String... textLog) throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir"), nameFile + "" + new Random().nextInt(1024));
        if (!file.createNewFile()) {
            throw new IllegalStateException(String.format("File could not created @s", file.getAbsoluteFile()));
        }
        try (final PrintWriter write = new PrintWriter(file)) {
            Stream.of(textLog).forEach(write::println);
        }
        return file;
    }

    /**
     * Reads the target file.
     * @param nameFile Target file name.
     * @return The contents of the target file.
     * @throws IOException
     */
    public String writeTargetFile(String nameFile) throws IOException {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(nameFile))) {
            read.lines().forEach(out::add);
        }
        return out.toString();
    }

    /**
     * Creates and passes a reference to the target file.
     * @param nameFile Target file name.
     * @return Target file reference.
     */
    public File refTargetFile(String nameFile) {
        return new File(System.getProperty("java.io.tmpdir"), nameFile);
    }

    /**
     * Two time ranges when the server was down.
     * @throws IOException
     */
    @Test
    public void whenSearchDiapason() throws IOException {
        File file = this.createLogFile(
                String.valueOf(System.currentTimeMillis()),
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "300 11:02:02"
        );
        File target = this.refTargetFile(String.valueOf(System.currentTimeMillis()));
        new Analyze().unavailable(
                file.getAbsolutePath(),
                target.getAbsolutePath()
        );
        String result = this.writeTargetFile(target.getAbsolutePath());
        String expected = new StringJoiner(System.lineSeparator())
                .add("10:57:01;10:59:01")
                .add("11:01:02;11:02:02")
                .toString();
        assertThat(result, is(expected));
        file.deleteOnExit();
        target.deleteOnExit();
    }

    /**
     * Server was down.
     * One range.
     * @throws IOException
     */
    @Test
    public void whenAllDiapason() throws IOException {
        File file = this.createLogFile(
                String.valueOf(System.currentTimeMillis()),
                "500 10:56:01",
                "400 10:58:01",
                "500 11:01:02",
                "400 11:02:02"
        );
        File target = this.refTargetFile(String.valueOf(System.currentTimeMillis()));
        new Analyze().unavailable(
                file.getAbsolutePath(),
                target.getAbsolutePath()
        );
        String result = this.writeTargetFile(target.getAbsolutePath());
        String expected = new StringJoiner(System.lineSeparator())
                .add("10:56:01;11:02:02")
                .toString();
        assertThat(result, is(expected));
        file.deleteOnExit();
        target.deleteOnExit();
    }

    /**
     * The server worked.
     * There is no ranges.
     * @throws IOException
     */
    @Test
    public void whenNotDiapason() throws IOException {
        File file = this.createLogFile(
                String.valueOf(System.currentTimeMillis()),
                "200 10:56:01",
                "300 10:58:01",
                "200 11:01:02",
                "200 11:02:02"
        );
        File target = this.refTargetFile(String.valueOf(System.currentTimeMillis()));
        new Analyze().unavailable(
                file.getAbsolutePath(),
                target.getAbsolutePath()
        );
        String result = this.writeTargetFile(target.getAbsolutePath());
        String expected = new StringJoiner(System.lineSeparator())
                .add("")
                .toString();
        assertThat(result, is(expected));
        file.deleteOnExit();
        target.deleteOnExit();
    }
}