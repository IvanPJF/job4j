package ru.job4j.tasks.statistics;

import java.util.List;

/**
 * Статистика по коллекции.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.01.2019
 *@version 0.1
 */
public class Analyze {

    /**
     * Сравнение первоначального состояния коллекции с текущим состоянием.
     * Сравнение по трём параметрам: добавление, изменение, удаление.
     * @param previous Первоначальное состояние коллекции.
     * @param current Текущее состояние коллекции.
     * @return Экземпляр класса, хранящий статистику об изменении коллекции.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User prevUser : previous) {
            int index = current.indexOf(prevUser);
            if (index != -1 && !current.get(index).name.equals(prevUser.name)) {
                info.changed++;
            } else if (index == -1) {
                info.deleted++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }
}
