package ru.job4j.transform;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * The sum of the values of the attributes.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class XMLSum {

    private int sumFields;

    /**
     * Considers the sum of the values of the attributes in all entry elements.
     * @param fileXML The file with the correct elements and attributes.
     * @return
     */
    public String sumValuesFields(File fileXML) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        String result = null;
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(fileXML, new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equals("entry")) {
                        String value = attributes.getValue("href");
                        sumFields += Integer.parseInt(value);
                    }
                }
            });
            result = String.format("The arithmetic sum of all the fields = %d", this.sumFields);
            System.out.println(result);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
