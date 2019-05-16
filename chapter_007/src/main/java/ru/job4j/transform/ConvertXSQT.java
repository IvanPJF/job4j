package ru.job4j.transform;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.StringJoiner;

/**
 * Convert XML file.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class ConvertXSQT {

    /**
     * The default schema for the conversion.
     * @return
     */
    private ByteArrayInputStream createDefaultSchema() {
        StringJoiner scheme = new StringJoiner(System.lineSeparator());
        scheme.add("<?xml version=\"1.0\"?>")
                .add("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">")
                .add("<xsl:output indent=\"yes\"/>")
                .add("<xsl:template match=\"/\">")
                .add("<xsl:text>")
                .add("</xsl:text>")
                .add("<entries>")
                .add("   <xsl:for-each select=\"entries/entry\">")
                .add("       <entry>")
                .add("           <xsl:attribute name=\"href\">")
                .add("               <xsl:value-of select=\"field\"/>")
                .add("           </xsl:attribute>")
                .add("       </entry>")
                .add("   </xsl:for-each>")
                .add(" </entries>")
                .add("</xsl:template>")
                .add("</xsl:stylesheet>");
        return new ByteArrayInputStream(scheme.toString().getBytes());
    }

    /**
     * Converts the XML file according to the specified schema.
     * When the schema is null, then the default schema is used.
     * @param source Xml file to convert.
     * @param dest File to save the new XML.
     * @param scheme Schema to convert XML file.
     */
    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            InputStream xsl = scheme != null ? new FileInputStream(scheme) : this.createDefaultSchema();
            Transformer transformer = factory.newTransformer(new StreamSource(xsl));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
