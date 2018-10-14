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
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            for (Task value : this.tasks) {
                if (value.getPriority() > task.getPriority()) {
                    this.tasks.add(this.tasks.indexOf(value), task);
                    break;
                }

            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}