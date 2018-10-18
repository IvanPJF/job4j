package ru.job4j.comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    /**
     * Тест Сортировка.
     */
    @Test
    public void whenSort() {
        List<User> list = new ArrayList<>();
        User first = new User("Stewie", 2);
        User second = new User("Lois", 43);
        User third = new User("Peter", 47);
        list.add(third);
        list.add(second);
        list.add(first);
        Set<User> result = new SortUser().sort(list);
        List<User> expect = new ArrayList<>();
        expect.add(first);
        expect.add(second);
        expect.add(third);
        assertThat(new ArrayList<>(result), is(expect));
    }
}