package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Простой HashMap.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.12.2018
 *@version 0.1
 */
public class SimpleHashMap<K, V> implements Iterable<V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] table = new Node[DEFAULT_CAPACITY];
    private int modCount;
    private int size;

    public SimpleHashMap() {
    }

    public SimpleHashMap(int size) {
        if (size > 0) {
            this.table = new Node[size];
        }
    }

    /**
     * Вставка новой пары ключ-значение в таблицу.
     * @param key Ключ.
     * @param value Значение.
     * @return Логический результат вставки.
     */
    public boolean insert(K key, V value) {
        if (this.size >= LOAD_FACTOR * this.table.length) {
            resize();
        }
        Node<K, V>[] tab = this.table;
        boolean result = false;
        int hash = hashFunc(key);
        int index = hash % tab.length;
        if (tab[index] == null) {
            tab[index] = new Node<>(hash, key, value);
            this.modCount++;
            this.size++;
            result = true;
        }
        return result;
    }

    /**
     * Поиск пары ключ-значение по ключу в таблице.
     * @param key Ключ.
     * @return Значение.
     */
    public V get(K key) {
        int index = hashFunc(key) % this.table.length;
        V result = null;
        Node<K, V> element = this.table[index];
        if (element != null && element.key != null && element.key.equals(key)) {
            result = element.value;
        }
        return result;
    }

    /**
     * Удалене пары ключ-значение по ключу из таблицы.
     * @param key Ключ.
     * @return Логический результат удаления.
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = hashFunc(key) % this.table.length;
        Node<K, V> element = this.table[index];
        if (element != null && element.key.equals(key)) {
            this.table[index] = null;
            this.modCount++;
            this.size--;
            result = true;
        }
        return result;
    }

    /**
     * Увеличение размера таблицы.
     * Производится при полном заполнении таблицы.
     * Увеличение предыдущего размера таблицы в два раза.
     */
    private void resize() {
        Node<K, V>[] temp = new Node[this.table.length << 1];
        for (Node<K, V> value : this.table) {
            if (value != null) {
                int index = value.hash % temp.length;
                if (temp[index] == null) {
                    temp[index] = value;
                }
            }
        }
        this.table = temp;
    }

    /**
     * Вычисление хеш-функции для ключа.
     * @param key Ключ.
     * @return Результат вычисления.
     */
    private int hashFunc(K key) {
        int result = 0;
        if (key != null) {
            result = Math.abs(key.hashCode());
            result ^= result >>> 16;
        }
        return result;
    }

    /**
     * Итератор для всех значений таблицы.
     * @return Итератор.
     * @throws ConcurrentModificationException Использование созданного итератора после увеличения длины массива.
     * @throws NoSuchElementException Отсутствии элемента.
     */
    @Override
    public Iterator<V> iterator() throws ConcurrentModificationException, NoSuchElementException {
        return new Iterator<V>() {

            private int position;
            private int elements;
            private int expectedModCount = modCount;

            /**
             * Проверка наличия следующего элемента.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                return size > elements;
            }

            /**
             * Перемещение каретки на следующий элемент.
             * @return Значение из пары ключ-значение.
             */
            @Override
            public V next() throws ConcurrentModificationException, NoSuchElementException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection is modified");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("No elements");
                }
                while (position < table.length && table[position] == null) {
                    position++;
                }
                elements++;
                return table[position++].value;
            }
        };
    }

    /**
     * Класс для хранения информации.
     * @param <K> Ключ.
     * @param <V> Значение.
     */
    private static class Node<K, V> {
        final int hash;
        final K key;
        final V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
