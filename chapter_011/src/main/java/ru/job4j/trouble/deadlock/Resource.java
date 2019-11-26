package ru.job4j.trouble.deadlock;

/**
 * Class resource.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class Resource implements IResource {

    private int value;
    private IResource resource;

    public Resource(int value) {
        this.value = value;
    }

    /**
     * Gets the value from the associated resource.
     * @return
     */
    public synchronized int getRes() {
        System.out.printf("In getRes, thread name = %s%n", Thread.currentThread().getName());
        return resource.getValue();
    }

    /**
     * Gets the value from this resource.
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    /**
     * Establishes a connection with another resource.
     * @param resource The resource that this resource will depend on.
     */
    public void setResource(IResource resource) {
        this.resource = resource;
    }
}
