package ru.job4j.list;

/**
 * Stack.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 29.11.2018
 *@version 0.1
 */
public class SimpleStack<T> extends DynamicList<T> {

    /**
     * Взять последний добавленный элемент.
     * @return Последний добавленный элемент.
     */
    public T poll() {
        return this.delete(0);
    }

    /**
     * Добавить элемент в стек.
     * @param value Добавляемый элемент.
     */
    public void push(T value) {
        this.add(value);
    }
}
