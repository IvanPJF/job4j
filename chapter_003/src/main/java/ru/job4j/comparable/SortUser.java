package ru.job4j.comparable;

import java.util.*;
import java.util.stream.Collectors;

/**Класс Сортировка списка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.10.2018
 *@version 0.1
 */
public class SortUser {

    /**
     * Сортировка по возрасту.
     * @param users Несортированный список.
     * @return Сортированный список.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Сортировка по длине имени.
     * @param users Несортированный список.
     * @return Сортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        return users.stream().sorted(
                Comparator.comparingInt(
                        value -> value.getName().length()
                )
        ).collect(Collectors.toList());
    }

    /**
     * Сортировка по имени и возрасту.
     * @param users Несортированный список.
     * @return Сортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        return users.stream().sorted(
                Comparator.comparing(User::getName).thenComparingInt(User::getAge)
        ).collect(Collectors.toList());
    }
}
