package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Конвертация ArrayList<User> в HashMap<Integer, User> с указанием id из поля класса User.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 17.10.2018
 *@version 0.1
 */
public class UserConvertTest {

    /**
     * Тест Конвертация - List в HashMap.
     */
    @Test
    public void whenListThenMap() {
        UserConvert userConvert = new UserConvert();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(2, "David", "USA"));
        list.add(new User(1, "Sara", "UK"));
        list.add(new User(100, "Hans", "Germany"));
        HashMap<Integer, User> result = userConvert.process(list);
        assertThat(result.get(100).getName(), is("Hans"));
    }
}