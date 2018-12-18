package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.12.2018
 *@version 0.1
 */
public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавление дочернего узла родительскому.
     * @param child Дочерний элемент.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Вывести все дочерние узлы родительского узла.
     * @return Список дочерних узлов.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Проверка эквивалентности искомого узла и существующего узла.
     * @param that Искомый узел.
     * @return Логический результат сравнения.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Вывод значения узла.
     * @return Значение узла.
     */
    public E getValue() {
        return this.value;
    }
}
