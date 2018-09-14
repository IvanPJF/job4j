package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест Проверка начала слова в определенной последовательности.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class ArrayCharTest {

    /**
     * Тест Совпадение префикса со словом.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Тест Отсутствует совпадение префикса со словом.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}
