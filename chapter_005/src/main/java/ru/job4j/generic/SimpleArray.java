package ru.job4j.generic;

import java.util.Iterator;

/**
 * Обёртка для массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 17.11.2018
 *@version 0.1
 */
public class SimpleArray<T> implements Iterable<T> {

    private final Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Добавление элемента массива.
     * @param value Элемент для добавления.
     * @throws ContainerIsFullException Ошибка при переполнении массива.
     */
    public void add(T value) throws ContainerIsFullException {
        if (this.index >= this.array.length) {
            throw new ContainerIsFullException("Is Full");
        }
        this.array[index++] = value;
    }

    /**
     * Изменение значения элемента массива.
     * @param index Индекс элемента, значение которого необходимо изменить.
     * @param value Новое значение.
     * @return Значение элемента до его изменения.
     */
    public T set(int index, T value) {
        T result;
        if (index < this.array.length) {
            result = (T) this.array[index];
            this.array[index] = value;
        } else {
            result = null;
        }
        return  result;
    }

    /**
     * Доступ к элементу массива по индексу.
     * @param index Индекс элемента массива.
     * @return Значение элемента массива.
     */
    public T get(int index) {
        return index < this.array.length ? (T) this.array[index] : null;
    }

    /**
     * Удаление элемента массива по индексу.
     * @param index Индекс удаляемого элемента.
     */
    public void delete(int index) {
        if (index < this.array.length - 1) {
            int size = this.array.length - index - 1;
            System.arraycopy(this.array, index + 1, this.array, index, size);
        } else if (index == this.array.length - 1) {
            this.array[index] = null;
        }
    }

    /**
     * Итератор для массива.
     * @return Итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int position = 0;

            @Override
            public boolean hasNext() {
                return this.position < array.length;
            }

            @Override
            public T next() {
                return (T) array[this.position++];
            }
        };
    }
}
