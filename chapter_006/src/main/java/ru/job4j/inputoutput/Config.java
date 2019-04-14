package ru.job4j.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * The class for the configurations.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.04.2019
 *@version 0.1
 */
public class Config {

    private static final String SP = "=";
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    /**
     * Load the contents of the file into memory.
     * @return An instance of the class with the loaded information from the file.
     */
    public Config load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(
                    line -> {
                        if (line.contains(SP)) {
                            int indexSP = line.indexOf(SP);
                            this.values.put(line.substring(0, indexSP), line.substring(indexSP + 1));
                        }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Returns value by key.
     * @param key The key whose value you want to get.
     * @return Value.
     */
    public String value(String key) {
        return this.values.get(key);
    }

    /**
     * Convert the contents of a file to a string.
     * The contents of the file are not changed.
     * @return Line from file.
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
