package ru.job4j.list;

/**
 * Связный список.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 21.11.2018
 *@version 0.1
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Добавление нового элемента в начало связного списка.
     * @param data Новый элемент.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Удаление первого элемента связанного списка.
     * @return Удаленный элемент.
     */
    public E delete() {
        Node<E> result = this.first;
        if (this.first != null) {
            this.first = this.first.next;
            result.next = null;
            this.size--;
        }
        return result != null ? result.data : null;
    }

    /**
     * Получение элемента из связного списка по индексу.
     * @param index Индекс элемента.
     * @return Элемент.
     * @throws IndexOutOfBoundsException Неверный индекс.
     */
    public E get(int index) throws IndexOutOfBoundsException {
        this.checkElementIndex(index);
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
     * Проверка наличия индекса.
     * @param index Индекс.
     * @throws IndexOutOfBoundsException Неверный индекс.
     */
    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}