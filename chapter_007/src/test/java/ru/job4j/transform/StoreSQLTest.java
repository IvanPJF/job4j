package ru.job4j.transform;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * Working with database.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class StoreSQLTest {

    /**
     * Add three entries to the database.
     */
    @Test
    public void whenGenerateThreeElements() throws Exception {
        Config config = new Config();
        List<Entry> expected = null;
        List<Entry> result = null;
        try (StoreSQL storeSQL = new StoreSQL(config)) {
            storeSQL.generate(3);
            expected = new LinkedList<>(Arrays.asList(new Entry(1), new Entry(2), new Entry(3)));
            result = storeSQL.load();
        }
        assertThat(result, is(expected));
    }

    /**
     * Add zero entries to the database.
     */
    @Test
    public void whenGenerateZeroElements() throws Exception {
        Config config = new Config();
        List<Entry> expected = null;
        List<Entry> result = null;
        try (StoreSQL storeSQL = new StoreSQL(config)) {
            storeSQL.generate(0);
            expected = new LinkedList<>();
            result = storeSQL.load();
        }
        assertThat(result, is(expected));
    }
}