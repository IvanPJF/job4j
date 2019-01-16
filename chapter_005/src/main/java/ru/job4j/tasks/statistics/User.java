package ru.job4j.tasks.statistics;

import java.util.Objects;

public class User {

    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            User user = (User) o;
            result = id == user.id;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
