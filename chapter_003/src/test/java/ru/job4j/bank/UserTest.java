package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест.
 * Клиент банка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 29.10.2018
 *@version 0.1
 */
public class UserTest {

    /**
     * Когда клиенты одинаковы.
     * Эквивалентность проверяется по паспорту.
     */
    @Test
    public void whenOneUserEqualsTwoUserThenTrue() {
        User oneUser = new User("Ivan", "123");
        User twoUser = new User("Ivan", "123");
        assertThat(oneUser.equals(twoUser), is(true));
    }

    /**
     * Когда клиенты разные.
     * Эквивалентность проверяется по паспорту.
     */
    @Test
    public void whenOneUserNotEqualsTwoUserThenFalse() {
        User oneUser = new User("Ivan", "123");
        User twoUser = new User("Ivan", "321");
        assertThat(oneUser.equals(twoUser), is(false));
    }

    /**
     * Когда клиент один.
     * Эквивалентность проверяется по паспорту.
     */
    @Test
    public void whenUserEqualsYourselfThenTrue() {
        User user = new User("Ivan", "123");
        assertThat(user.equals(user), is(true));
    }
}
