package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический массив.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 23.11.2018
 *@version 0.1
 */
public class DynamicArray<E> implements Iterable<E> {

    private Object[] array = new Object[this.defaultLength];
    private final int defaultLength = 10;
    private int modeCount = 0;
    private int size = 0;

    public DynamicArray() {
    }

    public DynamicArray(int value) {
        if (value >= 0) {
            this.array = new Object[value];
        }
    }

    /**
     * Увеличение длины массива.
     */
    private void editArray() {
        int sizeArr = this.array.length;
        if (this.size >= sizeArr) {
            if (sizeArr == 0) {
                sizeArr++;
            }
            this.array = Arrays.copyOf(this.array, sizeArr + sizeArr);
            this.modeCount++;
        }
    }

    /**
     * Добавление нового элемента в массив.
     * @param value Новый элемент.
     */
    public void add(E value) {
        this.editArray();
        this.array[size++] = value;
    }

    /**
     * Получение элемента массива по индексу.
     * @param index Индекс элемента.
     * @return Элемент.
     */
    public E get(int index) {
        E result = null;
        if (index >= 0 && index < this.size) {
            result = (E) this.array[index];
        }
        return result;
    }

    /**
     * Итератор массива.
     * @return Итератор.
     * @throws NoSuchElementException Отсутствии элемента.
     * @throws ConcurrentModificationException Использование созданного итератора после увеличения длины массива.
     */
    @Override
    public Iterator<E> iterator() throws NoSuchElementException, ConcurrentModificationException {
        return new Iterator<E>() {

            private int position = 0;
            private int expectedModCount = modeCount;

            /**
             * Проверка наличия оставшихся элементов.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                return size > position;
            }

            /**
             * Перемещение каретки на следующий элемент.
             * @return Следующий элемент.
             */
            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No element");
                }
                if (this.expectedModCount != modeCount) {
                    throw new ConcurrentModificationException("Collection is modified");
                }
                return (E) array[position++];
            }
        };
    }
}
