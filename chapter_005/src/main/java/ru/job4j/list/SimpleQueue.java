package ru.job4j.list;

/**
 * Queue.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 29.11.2018
 *@version 0.1
 */
public class SimpleQueue<T> {

    private SimpleStack<T> inStack = new SimpleStack<>();
    private SimpleStack<T> outStack = new SimpleStack<>();

    /**
     * Взять первый добавленный элемент(элемент удаляется из очереди).
     * @return Первый добавленный элемент.
     */
    public T poll() {
        if (this.outStack.getSize() == 0) {
            int inSize = this.inStack.getSize();
            if (inSize != 0) {
                for (int i = 0; i < inSize; i++) {
                    this.outStack.push(this.inStack.poll());
                }
            }
        }
        return this.outStack.getSize() != 0 ? this.outStack.poll() : null;
    }

    /**
     * Добавить новый элемент в очередь.
     * @param value Новый элемент.
     */
    public void push(T value) {
        this.inStack.push(value);
    }

    /**
     * Количество элементов в очереди.
     * @return Количество элементов.
     */
    public int getSize() {
        return this.inStack.getSize() + this.outStack.getSize();
    }
}
