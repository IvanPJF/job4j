package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;

/**
 * Множество на основе динамического массива.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.11.2018
 *@version 0.1
 */
public class SimpleSet<E> {

    private DynamicArray<E> set = new DynamicArray<>();

    /**
     * Добавление элемента в множество.
     * Дубликаты не добавляются.
     * @param value Новый добавляемый элемент.
     */
    public void add(E value) {
        if (!this.isDuplicate(value)) {
            this.set.add(value);
        }
    }

    /**
     * Итератор.
     * @return Итератор.
     */
    public Iterator<E> iterator() {
        return this.set.iterator();
    }

    /**
     * Проверка совпадения нового элемента с уже добавленными.
     * @param value Новый проверяемый элемент.
     * @return Результат: true - во множестве есть такой элемент, false - во множестве нет такого элемента.
     */
    private boolean isDuplicate(E value) {
        boolean result = false;
        for (E element : this.set) {
            if (value.equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Количество элементов множества.
     * @return Количество элементов.
     */
    public int getSize() {
        return this.set.getSize();
    }
}
