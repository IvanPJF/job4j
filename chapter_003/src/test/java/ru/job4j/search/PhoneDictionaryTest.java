package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Поиск объекта в справочнике по ключу.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.10.2018
 *@version 0.1
 */
public class PhoneDictionaryTest {
    /**
     * Тест Поиск по имени.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Krinitsyn", "9101234567", "Kostroma")
        );
        List<Person> persons = phones.find("Ivan");
        assertThat(persons.iterator().next().getSurname(), is("Krinitsyn"));
    }

    /**
     * Тест Поиск по фамилии.
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Krinitsyn", "9101234567", "Kostroma")
        );
        List<Person> persons = phones.find("Krinitsyn");
        assertThat(persons.iterator().next().getName(), is("Ivan"));
    }

    /**
     * Тест Поиск по номеру телефона.
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Krinitsyn", "9101234567", "Kostroma")
        );
        List<Person> persons = phones.find("9101234567");
        assertThat(persons.iterator().next().getSurname(), is("Krinitsyn"));
    }

    /**
     * Тест Поиск по номеру адресу.
     */
    @Test
    public void whenFindByAdress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Krinitsyn", "9101234567", "Kostroma")
        );
        List<Person> persons = phones.find("Kostroma");
        assertThat(persons.iterator().next().getSurname(), is("Krinitsyn"));
    }
}
