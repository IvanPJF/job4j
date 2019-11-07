package ru.job4j.mail;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Class user.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 01.11.2019
 */
public class User implements Comparable<User> {

    private final String name;
    private final Set<String> emails = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public void addEmails(Set<String> emails) {
        this.emails.addAll(emails);
    }

    public Set<String> getEmails() {
        return emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name)
                && Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emails);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", emails=" + emails
                + '}';
    }

    @Override
    public int compareTo(User o) {
        int compName = name.compareTo(o.name);
        return compName != 0 ? compName : Objects.compare(emails, o.emails, (o1, o2) -> {
            int result = Integer.compare(o1.size(), o2.size());
            if (result == 0) {
                Iterator<String> iterO1 = o1.iterator();
                Iterator<String> iterO2 = o2.iterator();
                while (iterO1.hasNext()) {
                    result = iterO1.next().compareTo(iterO2.next());
                    if (result != 0) {
                        break;
                    }
                }
            }
            return result;
        });
    }
}
