package ru.job4j.comparable;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    /**
     * Тест Сортировка по возрасту.
     */
    @Test
    public void whenSort() {
        User first = new User("Stewie", 2);
        User second = new User("Lois", 43);
        User third = new User("Peter", 47);
        List<User> list = new ArrayList<>(Arrays.asList(
                third, second, first
        ));
        Set<User> result = new SortUser().sort(list);
        List<User> expect = new ArrayList<>(Arrays.asList(
                first, second, third
        ));
        assertThat(new ArrayList<>(result), is(expect));
    }

    /**
     * Тест Сортировка по длине имени.
     */
    @Test
    public void whenSortNameLength() {
        User first = new User("Lois", 43);
        User second = new User("Peter", 47);
        User third = new User("Loiseta", 2);
        List<User> list = new ArrayList<>(Arrays.asList(
                third, second, first
        ));
        List<User> result = new SortUser().sortNameLength(list);
        List<User> expect = new ArrayList<>(Arrays.asList(
                first, second, third
        ));
        assertThat(new ArrayList<>(result), is(expect));
    }

    /**
     * Тест Сортировка по имени и возрасту.
     */
    @Test
    public void whenSortNameAndAge() {
        User first = new User("Lois", 2);
        User second = new User("Lois", 43);
        User third = new User("Peter", 16);
        User fourth = new User("Peter", 47);
        List<User> list = new ArrayList<>(Arrays.asList(
                fourth, second, first, third
        ));
        List<User> result = new SortUser().sortByAllFields(list);
        List<User> expect = new ArrayList<>(Arrays.asList(
                first, second, third, fourth
        ));
        assertThat(new ArrayList<>(result), is(expect));
    }
}