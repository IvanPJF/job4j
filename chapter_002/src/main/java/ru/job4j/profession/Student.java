package ru.job4j.profession;

/**Студент.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Student {
    private String name;
    private Graduate graduate;

    public Student() {
    }

    public Student(String name, Graduate graduate) {
        this.name = name;
        this.graduate = graduate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Graduate getGraduate() {
        return graduate;
    }

    public void setGraduate(Graduate graduate) {
        this.graduate = graduate;
    }
}