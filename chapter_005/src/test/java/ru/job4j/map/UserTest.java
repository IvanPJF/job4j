package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Модель User.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 01.12.2018
 *@version 0.1
 */
public class UserTest {

    @Test
    public void whenAddTwoUserToMapAndPrintThenResultIsTwoUser() {
        Map<User, Object> map = new HashMap<>();
        Calendar birthday = new GregorianCalendar(2000, 1, 1);
        User first = new User("Ivan", 1, birthday);
        User second = new User("Ivan", 1, birthday);
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }

    @Test
    public void whenTwoUserEqualsThenTrue() {
        Calendar birthday = new GregorianCalendar(2000, 1, 1);
        User first = new User("Ivan", 1, birthday);
        User second = new User("Ivan", 1, birthday);
        assertThat(first.equals(second), is(true));
        assertThat(second.equals(first), is(true));
    }

    @Test
    public void whenTwoUserNotEqualsThenFalse() {
        Calendar birthday = new GregorianCalendar(2000, 1, 1);
        User first = new User("Ivan", 1, birthday);
        User second = new User("Oleg", 0, birthday);
        assertThat(first.equals(second), is(false));
        assertThat(second.equals(first), is(false));
    }

    @Test
    public void whenOneUserIsNullThenFalse() {
        Calendar birthday = new GregorianCalendar(2000, 1, 1);
        User first = new User("Ivan", 1, birthday);
        User second = null;
        assertThat(first.equals(second), is(false));
    }
}