package ru.job4j.profession;

/**Дом.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class House {
    private String name;

    public House() {
    }

    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}