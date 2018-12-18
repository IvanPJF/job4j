package ru.job4j.tree;

import java.util.*;

/**
 * Tree.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.12.2018
 *@version 0.1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private final Node<E> root;
    private int modCount;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Добавление родительскому узлу дочернего узла.
     * @param parent Родительский узел.
     * @param child Дочерний узел.
     * @return Логический результат добавления.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> findParent = findBy(parent);
        if (findParent.isPresent() && !findBy(child).isPresent()) {
            Node<E> elem = findParent.get();
            elem.add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
    }

    /**
     * Поиск значения узла в дереве.
     * @param value Искомое значение.
     * @return Результат поиска.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> elem = data.poll();
            if (elem.eqValue(value)) {
                result = Optional.of(elem);
                break;
            }
            for (Node<E> child : elem.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Итератор дерева.
     * @return Итератор.
     * @throws ConcurrentModificationException Коллекция модифицирована после создания итератора.
     * @throws NoSuchElementException Отсутствие элементов.
     */
    @Override
    public Iterator<E> iterator() throws ConcurrentModificationException, NoSuchElementException {
        return new Iterator<E>() {

            private Queue<Node<E>> elements = addRoot();
            private int expectedModCount = modCount;

            /**
             * Проверка наличия следующего элемента.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }

            /**
             * Перемещение каретки на следующий элемент.
             * @return Значение из пары ключ-значение.
             */
            @Override
            public E next() throws ConcurrentModificationException, NoSuchElementException {
                modified();
                noElements();
                Node<E> elem = elements.poll();
                for (Node<E> child : elem.leaves()) {
                    elements.offer(child);
                }
                return elem.getValue();
            }

            /**
             * Исключение при отсутствии элементов.
             */
            private void noElements()  {
                if (!hasNext()) {
                    throw new NoSuchElementException("No elements");
                }
            }

            /**
             * Исключение при использовании итератора после модификации коллекции.
             */
            private void modified() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection is modified");
                }
            }

            /**
             * Создание очереди, изначально содержащей корень дерева.
             * @return Очередь.
             */
            private LinkedList<Node<E>> addRoot() {
                LinkedList<Node<E>> newLinked = new LinkedList<>();
                newLinked.offer(root);
                return newLinked;
            }
        };
    }
}
