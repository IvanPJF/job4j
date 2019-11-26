package ru.job4j.trouble.deadlock;

/**
 * Class print runnable.
 * Resource value output.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 26.11.2019
 */
public class PrintRunnable implements Runnable {

    private IResource resource;

    public PrintRunnable(IResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println(resource.getRes());
    }
}
