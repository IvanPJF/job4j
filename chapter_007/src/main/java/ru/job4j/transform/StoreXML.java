package ru.job4j.transform;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Create an XML file from the Entry list.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class StoreXML {

    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Convert the Entry list to an XML file.
     * @param list List for conversion.
     * @throws JAXBException
     */
    public void save(List<Entry> list) {
        try {
            JAXBContext context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Entries(list), this.target);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @XmlRootElement
    private static class Entries {

        private List<Entry> entries;

        public Entries() {
        }

        public Entries(List<Entry> entries) {
            this.entries = entries;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        @XmlElement(name = "entry")
        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }
    }
}
