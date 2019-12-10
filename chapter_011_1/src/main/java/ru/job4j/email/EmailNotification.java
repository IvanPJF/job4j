package ru.job4j.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class email notification.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 10.12.2019
 */
public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    /**
     * In multithreaded mode sends mail.
     * Generates an address and content from a user object.
     *
     * @param user
     */
    public void emailTo(IUser user) {
        this.pool.submit(() -> {
            String userName = user.getUserName();
            String userEmail = user.getEmail();
            this.send(
                    String.format("Notification %s to email %s", userName, userEmail),
                    String.format("Add a new event to %s", userName),
                    userEmail
            );
        });
    }

    /**
     * Explicitly sends mail.
     *
     * @param subject
     * @param body
     * @param email
     */
    public void send(String subject, String body, String email) {
    }

    /**
     * Terminates all threads.
     */
    public void close() {
        this.pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
