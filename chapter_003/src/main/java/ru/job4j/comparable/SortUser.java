package ru.job4j.comparable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**Класс Сортировка списка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.10.2018
 *@version 0.1
 */
public class SortUser {

    public Set<User> sort(List<User> user) {
        return new TreeSet<>(user);
    }
}
