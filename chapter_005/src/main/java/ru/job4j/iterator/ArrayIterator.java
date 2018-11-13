package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двумерного массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.11.2018
 *@version 0.1
 */
public class ArrayIterator implements Iterator {
    private final int[][] values;
    private int rows = 0;
    private int columns = 0;

    public ArrayIterator(final int[][] values) {
        this.values = values;
    }

    /**
     * Проверка наличия следующего эемента.
     * @return Наличие следующего элемента.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (
                this.values.length - 1 > rows
                        || this.values.length - 1 == rows
                        && this.values[this.values.length - 1].length > columns
        ) {
            result = true;
        }
        return result;
    }

    /**
     * Переход к следующему элементу.
     * @return Элемент.
     * @throws NoSuchElementException Выброс ошибки, сообщающей о том, что нет элементов.
     */
    @Override
    public Object next() throws NoSuchElementException {
        int result = -1;
        if (this.values.length == 0) {
            throw new NoSuchElementException("No element");
        }
        if (this.values[rows].length > columns) {
            result = this.values[rows][columns++];
        } else if (this.values[rows].length == columns) {
            columns = 0;
            result = this.values[++rows][columns++];
        }
        return result;
    }
}
