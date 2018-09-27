package ru.job4j.profession;

/**Диагноз.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Diagnose {
    private String name;

    public Diagnose() {
    }

    public Diagnose(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}