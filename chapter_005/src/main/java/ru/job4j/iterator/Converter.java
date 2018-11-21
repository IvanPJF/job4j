package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Конвертер для итератора итераторов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 15.11.2018
 *@version 0.1
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator;

            /**
             * Проверка наличия оставшихся элементов.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (it.hasNext() || this.iterator.hasNext()) {
                    if (this.iterator == null || !this.iterator.hasNext()) {
                        this.iterator = it.next();
                    }
                    if (this.iterator.hasNext()) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            /**
             * Перемещение каретки на следующий элемент.
             * @return Следующий элемент.
             */
            @Override
            public Integer next() {
                int result;
                if (!this.hasNext()) {
                    throw new NoSuchElementException("No element");
                }
                result = this.iterator.next();
                return result;
            }
        };
    }
}