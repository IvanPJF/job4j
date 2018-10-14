package ru.job4j.search;

/**Задача.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.10.2018
 *@version 0.1
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
