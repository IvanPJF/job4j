package ru.job4j.generic.store;

import ru.job4j.generic.ContainerIsFullException;
import ru.job4j.generic.SimpleArray;

import java.util.stream.IntStream;

/**
 * Абстрактный класс для типизированного контейнера.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.11.2018
 *@version 0.1
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Добавление элемента в контейнер.
     * @param model Элемент для добавления.
     * @throws ContainerIsFullException Ошибка переполнения контейнера.
     */
    @Override
    public void add(T model) throws ContainerIsFullException {
        this.simpleArray.add(model);
    }

    /**
     * Изменение элемента контейнера по id.
     * @param id Id изменяемого элемента.
     * @param model Изменяющий элемент.
     * @return Логический результат изменения элемента.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index != -1) {
            this.simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    /**
     * Удаление элемента из контейнера по id.
     * @param id Id удаляемого элемета.
     * @return Логический результат удаления элемента.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index != -1) {
            this.simpleArray.delete(index);
            result = true;
        }
        return result;
    }

    /**
     * Поиск элемента в коллекции по id.
     * @param id Id искомого элемента.
     * @return Искомый элемент(null если нет элемента с таким id).
     */
    @Override
    public T findById(String id) {
        int index = this.findIndex(id);
        return index != -1 ? this.simpleArray.get(index) : null;
    }

    /**
     * Поиск индекса элемента в контейнере.
     * @param id Id элемента.
     * @return Искомый индекс элемента.
     */
    private int findIndex(String id) {
        return IntStream
                .range(0, this.simpleArray.getSize())
                .filter(i -> id.equals(this.simpleArray.get(i).getId()))
                .findFirst().orElse(-1);
    }
}
