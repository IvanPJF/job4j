package ru.job4j.transform;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * Create an XML file from the Entry list.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class StoreXMLTest {

    /**
     * Create XML from three Entry objects.
     * @throws IOException
     */
    @Test
    public void whenThreeEntry() throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        String fileName = String.format("%dTarget", System.currentTimeMillis());
        File fileTarget = new File(tmp, fileName);
        StoreXML storeXML = new StoreXML(fileTarget);
        storeXML.save(Arrays.asList(new Entry(1), new Entry(2), new Entry(3)));
        String result = this.xmlFileToString(fileTarget);
        String expected = new StringJoiner(System.lineSeparator())
                .add("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .add("<entries>")
                .add("<entry>")
                .add("<field>1</field>")
                .add("</entry>")
                .add("<entry>")
                .add("<field>2</field>")
                .add("</entry>")
                .add("<entry>")
                .add("<field>3</field>")
                .add("</entry>")
                .add("</entries>")
                .toString();
        fileTarget.deleteOnExit();
        assertThat(result, is(expected));
    }

    /**
     * Convert XML file to string.
     * @param fileXML File to convert.
     * @return
     * @throws IOException
     */
    public String xmlFileToString(File fileXML) throws IOException {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader br = new BufferedReader(new FileReader(fileXML))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                result.add(line.trim());
            }
        }
        return result.toString();
    }
}