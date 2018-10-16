package ru.job4j.search;

import java.util.LinkedList;

/**Очередь с приоритетами.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.10.2018
 *@version 0.1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task value : this.tasks) {
            if (!this.tasks.isEmpty() && value.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}