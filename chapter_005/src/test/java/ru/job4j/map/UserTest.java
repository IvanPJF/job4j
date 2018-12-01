package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

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
}