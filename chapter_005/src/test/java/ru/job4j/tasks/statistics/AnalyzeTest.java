package ru.job4j.tasks.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Статистика по коллекции.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.01.2019
 *@version 0.1
 */
public class AnalyzeTest {

    /**
     * Изменений нет.
     */
    @Test
    public void whenNoChangeThenZeroZeroZero() {
        List<User> previous = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        List<User> current = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        Info info = new Analyze().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    /**
     * Добавление одного нового элемента.
     */
    @Test
    public void whenAddOneNewUserThenOneZeroZero() {
        List<User> previous = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        List<User> current = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah"),
                        new User(5, "ADDED")
                )
        );
        Info info = new Analyze().diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    /**
     * Изменение двух элементов.
     */
    @Test
    public void whenChangeTwoUserThenZeroTwoZero() {
        List<User> previous = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        List<User> current = new ArrayList<>(
                Arrays.asList(
                        new User(1, "CHANGED"), new User(2, "John"),
                        new User(3, "CHANGED"), new User(4, "Sarah")
                )
        );
        Info info = new Analyze().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(0));
    }

    /**
     * Удаление трёх элементов.
     */
    @Test
    public void whenDeleteThreeUserThenZeroZeroThree() {
        List<User> previous = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        List<User> current = new ArrayList<>(
                Arrays.asList(
                        new User(2, "John")
                )
        );
        Info info = new Analyze().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(3));
    }

    /**
     * Добавление одного нового элемента.
     * Изменение двух элементов.
     * Удаление двух элементов.
     */
    @Test
    public void whenAddOneNewUserAndChangedTwoUsersAndDeleteTwoUsersThenOneTwoTwo() {
        List<User> previous = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Andrew"), new User(2, "John"),
                        new User(3, "Mike"), new User(4, "Sarah")
                )
        );
        List<User> current = new ArrayList<>(
                Arrays.asList(
                        new User(1, "CHANGED"), new User(2, "CHANGED"),
                        new User(5, "ADDED")
                )
        );
        Info info = new Analyze().diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(2));
    }
}