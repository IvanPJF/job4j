package ru.job4j.memory;

/**
 * Stack overflow demonstration.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 31.10.2019
 */
public class StackOverFlowErrorDemo {

    /**
     * Calls itself, thereby filling the stack.
     * @throws StackOverflowError
     */
    public void addMethodToStack() throws StackOverflowError {
        addMethodToStack();
    }
}
