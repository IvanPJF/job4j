package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Связный список.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 26.11.2018
 *@version 0.1
 */
public class DynamicList<E> implements Iterable<E> {

    private Node<E> first;
    private int size;
    private int modCount;

    /**
     * Добавление элемента в связный список.
     * @param value Добавляемый элемент.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Получение элемента из связного списка по индексу.
     * @param index Инндекс элемента.
     * @return Элемент.
     * @throws IndexOutOfBoundsException Неверный индекс.
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Количество элементов связного списка.
     * @return Количество элементов.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    /**
     * Итератор связного списка.
     * @return Итератор.
     * @throws ConcurrentModificationException Использование созданного итератора после увеличения длины массива.
     * @throws NoSuchElementException Отсутствии элемента.
     */
    @Override
    public Iterator<E> iterator() throws ConcurrentModificationException, NoSuchElementException {
        return new Iterator<E>() {

            private int position;
            private Node<E> lastReturned;
            private Node<E> nextElement = first;
            private int expectedModCount = modCount;

            /**
             * Проверка наличия оставшихся элементов.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                return this.position < size;
            }

            /**
             * Перемещение каретки на следующий элемент.
             * @return Следующий элемент.
             */
            @Override
            public E next() throws ConcurrentModificationException, NoSuchElementException {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection is modified");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("No element");
                }
                this.lastReturned = this.nextElement;
                this.nextElement = this.nextElement.next;
                this.position++;
                return lastReturned.data;
            }
        };
    }
}
