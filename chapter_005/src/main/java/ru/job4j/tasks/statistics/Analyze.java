package ru.job4j.tasks.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, User> currMap = new HashMap<>();
        for (User curr : current) {
            currMap.put(curr.id, curr);
        }
        for (User prevUser : previous) {
            boolean idEq = currMap.containsKey(prevUser.id);
            if (idEq && !currMap.get(prevUser.id).equals(prevUser)) {
                info.changed++;
            } else if (!idEq) {
                info.deleted++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }
}
