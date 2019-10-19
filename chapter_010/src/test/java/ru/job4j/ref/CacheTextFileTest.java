package ru.job4j.ref;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CacheTextFileTest {

    private final String tmpDir = System.getProperty("java.io.tmpdir");
    private static final String LS = System.lineSeparator();

    private File createFile(String nameFile, String text) throws IOException {
        File file = new File(tmpDir, nameFile);
        if (file.exists()) {
            file.delete();
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        }
        return file;
    }

    @Test
    public void whenCacheIsEmptyThenReadFromFileAndAddToCache() throws IOException {
        ICache<String, String> cache = new CacheTextFile(tmpDir);
        String text = new StringJoiner(LS)
                .add("Philip").add("Lila").add("Hermes").add("Bender").toString();
        File file = createFile("Names.txt", text);
        String key = file.getName();
        String result = cache.getValue(key);
        assertThat(result, is(text));
    }

    @Test
    public void whenCacheContainsDataThenReadFromCache() throws IOException {
        ICache<String, String> cache = new CacheTextFile(tmpDir);
        String text = new StringJoiner(LS)
                .add("Philip").add("Lila").add("Hermes").add("Bender").toString();
        File file = createFile("Names.txt", text);
        String key = file.getName();
        cache.getValue(key);
        String result = cache.getValue(key);
        assertThat(result, is(text));
    }
}