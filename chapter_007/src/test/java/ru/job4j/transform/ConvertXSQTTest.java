package ru.job4j.transform;

import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * Convert XML file.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class ConvertXSQTTest {

    /**
     * Convert the XML file to the default schema.
     * @throws IOException
     */
    @Test
    public void whenConvertXML() throws IOException {
        String stringXML = new StringJoiner(System.lineSeparator())
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
        File fileXML = this.createXMLFile(stringXML);
        File fileTarget = this.createFile("target.xml");
        new ConvertXSQT().convert(fileXML, fileTarget, null);
        String result = this.xmlFileToString(fileTarget);
        String expected = new StringJoiner(System.lineSeparator())
                .add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .add("<entries>")
                .add("    <entry href=\"1\"/>")
                .add("    <entry href=\"2\"/>")
                .add("    <entry href=\"3\"/>")
                .add("</entries>")
                .toString();
        fileXML.deleteOnExit();
        fileTarget.deleteOnExit();
        assertThat(result, is(expected));
    }

    /**
     * Create XML file from XML string.
     * @param value XML string.
     * @return
     * @throws IOException
     */
    private File createXMLFile(String value) throws IOException {
        File fileXML = this.createFile("XML.xml");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileXML))) {
            bw.write(value);
        }
        return fileXML;
    }

    /**
     * Create file in temporary directory.
     * @param name The name of the file to create.
     * @return
     */
    private File createFile(String name) {
        String tmp = System.getProperty("java.io.tmpdir");
        String fileName = String.format("%d%s", System.currentTimeMillis(), name);
        return new File(tmp, fileName);
    }

    /**
     * Convert XML file to string.
     * @param fileXML File to convert.
     * @return
     * @throws IOException
     */
    private String xmlFileToString(File fileXML) throws IOException {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader br = new BufferedReader(new FileReader(fileXML))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result.toString();
    }
}