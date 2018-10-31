package ru.job4j.department;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест.
 * Сортировка департаментов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.10.2018
 *@version 0.1
 */
public class SortTest {

    /**
     * Тест.
     * Сортировка по возрастанию.
     */
    @Test
    public void whenUpSortDepartment() {
        String[] input = {
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        };
        String[] expect = {
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        };
        assertThat(new Sort().sortUp(input), is(expect));
    }

    /**
     * Тест.
     * Сортировка по убыванию.
     */
    @Test
    public void whenDownSortDepartment() {
        String[] input = {
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        };
        String[] expect = {
                "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"
        };
        assertThat(new Sort().sortDown(input), is(expect));
    }
}
