package ru.job4j.profession;

/**Выпускник.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Graduate {
    private String name;

    public Graduate() {
    }

    public Graduate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}