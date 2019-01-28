package ru.job4j.inputoutput;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Удаление запрещённых слов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.01.2019
 *@version 0.1
 */
public class WordFilter {

    /**
     * Удаляет запрещённые слова из потока.
     * @param in Входящий поток.
     * @param out Выходящий поток без запрещённых слов.
     * @param abuse Массив запрещённых слов.
     */
    public void dropAbuses(Reader in, Writer out, String[] abuse) {
        String currentRead;
        Set<String> abuseSet = new HashSet<>(Arrays.asList(abuse));
        try (BufferedReader reader = new BufferedReader(in);
             BufferedWriter writer = new BufferedWriter(out)) {
            while ((currentRead = reader.readLine()) != null) {
                for (String value : currentRead.split(" ")) {
                    if (!abuseSet.contains(value)) {
                        writer.write(value + " ");
                    }
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
