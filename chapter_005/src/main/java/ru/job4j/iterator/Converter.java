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
            private Iterator<Integer> iterator = it.next();

            /**
             * Проверка наличия оставшихся элементов.
             * @return Логический результат проверки.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.iterator.hasNext()) {
                    result = true;
                } else if (it.hasNext()) {
                    this.iterator = it.next();
                    result = this.iterator.hasNext();
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
                if (this.iterator.hasNext()) {
                    result = this.iterator.next();
                } else if (it.hasNext()) {
                    this.iterator = it.next();
                    result = this.iterator.next();
                } else {
                    throw new NoSuchElementException("No element");
                }
                return result;
            }
        };
    }
}