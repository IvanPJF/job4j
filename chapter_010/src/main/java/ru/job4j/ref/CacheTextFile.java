package ru.job4j.ref;

import java.io.*;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static java.util.Objects.isNull;

/**
 * Cache for text files.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 19.10.2019
 */
public class CacheTextFile implements ICache<String, String> {

    private final Map<String, SoftReference<String>> caches = new HashMap<>();
    private final File workDir;

    public CacheTextFile(String workDir) {
        this.workDir = new File(workDir);
    }

    @Override
    public String getValue(String key) {
        Reference<String> ref = caches.get(key);
        if (isNull(ref) || isNull(ref.get())) {
            caches.put(key, refWithValue(key));
        }
        return caches.get(key).get();
    }

    /**
     * Creates a reference to the value for this key.
     * Reads text from a file, translates text into string format and assigns it a soft reference.
     *
     * @param fileName
     * @return
     */
    private SoftReference<String> refWithValue(String fileName) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(workDir, fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                joiner.add(line);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return new SoftReference<>(joiner.toString());
    }
}
