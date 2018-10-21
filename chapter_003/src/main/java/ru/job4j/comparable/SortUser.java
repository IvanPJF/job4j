package ru.job4j.comparable;

import java.util.*;

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
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(
                                o1.getName().length(), o2.getName().length()
                        );
                    }
                });
        return users;
    }

    /**
     * Сортировка по имени и возрасту.
     * @param users Несортированный список.
     * @return Сортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int sortName = o1.getName().compareTo(o2.getName());
                        return sortName != 0 ? sortName : Integer.compare(o1.getAge(), o2.getAge());
                    }
                });
        return users;
    }
}
