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
    private int indexEven;

    public EvenIterator(final int[] values) {
        this.values = values;
        this.indexEven = findEven();
    }

    /**
     * Проверка наличия в массиве оставшихся чётных чисел.
     * @return Логический результат проверки.
     */
    public int findEven() {
        return IntStream.range(this.indexEven, this.values.length)
                .filter(index -> this.values[index] % 2 == 0)
                .findFirst().orElse(-1);
    }

    /**
     * Проверка наличия в массиве оставшихся чётных чисел.
     * @return Логический результат проверки.
     */
    @Override
    public boolean hasNext() {
        return this.indexEven != -1;
    }

    /**
     * Передвижение каретки по чётным числам массива.
     * @return Очередное чётное число массива.
     * @throws NoSuchElementException Ошибка при отсутствии оставшихся чётных чисел.
     */
    @Override
    public Object next() throws NoSuchElementException {
        if (this.indexEven == -1) {
            throw new NoSuchElementException("No element");
        }
        int result = this.values[this.indexEven++];
        this.indexEven = this.findEven();
        return result;
    }
}
