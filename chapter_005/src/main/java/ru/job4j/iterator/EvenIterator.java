package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Итератор для чётных чисел массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.11.2018
 *@version 0.1
 */
public class EvenIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    public EvenIterator(final int[] values) {
        this.values = values;
    }

    /**
     * Проверка наличия в массиве оставшихся чётных чисел.
     * @return Логический результат проверки.
     */
    public boolean findEven() {
        return IntStream.range(this.index, this.values.length)
                .anyMatch(i -> this.values[i] % 2 == 0);
    }

    /**
     * Проверка наличия в массиве оставшихся чётных чисел.
     * @return Логический результат проверки.
     */
    @Override
    public boolean hasNext() {
        return findEven();
    }

    /**
     * Передвижение каретки по чётным числам массива.
     * @return Очередное чётное число массива.
     * @throws NoSuchElementException Ошибка при отсутствии оставшихся чётных чисел.
     */
    @Override
    public Object next() throws NoSuchElementException {
        int result = -1;
        if (!findEven()) {
            throw new NoSuchElementException("No element");
        }
        while (findEven()) {
            if (this.values[this.index] % 2 == 0) {
                result = this.values[this.index++];
                break;
            }
            this.index++;
        }
        return result;
    }
}
