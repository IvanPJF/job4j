package ru.job4j.transform;

import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * The sum of the values of the attributes.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class XMLSumTest {

    /**
     * The sum of all values is ten.
     * @throws IOException
     */
    @Test
    public void whenEntryIsFourThenSumIsTen() throws IOException {
        String stringXML = new StringJoiner(System.lineSeparator())
                .add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .add("<entries>")
                .add("   <entry href=\"1\"/>")
                .add("   <entry href=\"2\"/>")
                .add("   <entry href=\"3\"/>")
                .add("   <entry href=\"4\"/>")
                .add("</entries>")
                .toString();
        File fileXML = this.createXMLFile(stringXML);
        XMLSum xmlSum = new XMLSum();
        String result = xmlSum.sumValuesFields(fileXML);
        String expected = "The arithmetic sum of all the fields = 10";
        fileXML.deleteOnExit();
        assertThat(result, is(expected));
    }

    /**
     * Create XML file from XML string.
     * @param value XML string.
     * @return
     * @throws IOException
     */
    public File createXMLFile(String value) throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        String fileName = String.format("%dXML", System.currentTimeMillis());
        File fileXML = new File(tmp, fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileXML))) {
            bw.write(value);
        }
        return fileXML;
    }
}