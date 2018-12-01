package ru.job4j.map;

import java.util.Calendar;

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
