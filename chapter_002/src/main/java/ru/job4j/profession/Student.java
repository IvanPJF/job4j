package ru.job4j.profession;

/**Студент.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Student {
    public String name;
    public Graduate graduate;

    public Student() {
    }

    public Student(String name, Graduate graduate) {
        this.name = name;
        this.graduate = graduate;
    }
}