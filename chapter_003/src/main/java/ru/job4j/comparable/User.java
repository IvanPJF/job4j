package ru.job4j.comparable;

/**Класс с полями, для коллекции.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.10.2018
 *@version 0.1
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
