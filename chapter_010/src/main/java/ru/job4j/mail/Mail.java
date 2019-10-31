package ru.job4j.mail;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class mail.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 01.11.2019
 */
public class Mail {

    /**
     * Merge users when matching email.
     *
     * @param users Unverified recruitment of users.
     * @return A proven set of users.
     */
    public Set<User> mergePossibleUsers(Set<User> users) {
        Map<String, Node> emails = new HashMap<>();
        for (User user : users) {
            boolean isMerged = false;
            Node newNode = new Node(user);
            for (String email : user.getEmails()) {
                if (!isMerged && emails.containsKey(email)) {
                    Node oldNode = emails.get(email);
                    oldNode.getUser().addEmails(newNode.getUser().getEmails());
                    newNode.changeUser(oldNode.getUser());
                    isMerged = true;
                }
                emails.put(email, newNode);
            }
        }
        return extractUsers(emails);
    }

    /**
     * Retrieves nodes from the resulting mapping for further extraction of users from them.
     *
     * @param emails
     * @return
     */
    private Set<User> extractUsers(Map<String, Node> emails) {
        Set<User> result = new TreeSet<>();
        for (Mail.Node node : emails.values()) {
            result.add(node.getUser());
        }
        return result;
    }

    /**
     * Utility class.
     * To control users when they merge.
     */
    private static class Node {

        private User user;

        Node(User user) {
            this.user = user;
        }

        User getUser() {
            return user;
        }

        void changeUser(User user) {
            this.user = user;
        }
    }
}
