package ru.job4j.list;

/**
 * Связанный список.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.11.2018
 *@version 0.1
 */
class Node<T> {

    T value;
    Node<T> next;
    boolean isRepeat;

    Node(T value) {
        this.value = value;
    }
}
