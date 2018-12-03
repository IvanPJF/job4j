package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Модель User.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 01.12.2018
 *@version 0.1
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = true;
        if (this != o) {
            if (o == null || getClass() != o.getClass()) {
                result = false;
            } else {
                User user = (User) o;
                result = children == user.children
                        && Objects.equals(name, user.name)
                        && Objects.equals(birthday, user.birthday);
            }
        }
        return result;
    }

    public String getName() {
        return this.name;
    }

    public int getChildren() {
        return this.children;
    }

    public Calendar getBirthday() {
        return this.birthday;
    }
}
