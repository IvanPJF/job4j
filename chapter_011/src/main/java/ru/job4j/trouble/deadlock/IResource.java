package ru.job4j.trouble.deadlock;

/**
 * Resource interface.
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public interface IResource {

    /**
     * Gets the value from the associated resource.
     * @return
     */
    int getRes();

    /**
     * Gets the value from this resource.
     * @return
     */
    int getValue();

    /**
     * Establishes a connection with another resource.
     * @param resource
     */
    void setResource(IResource resource);
}
