package ru.job4j.profession;

/**Учитель, учит студентов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Teacher extends Profession {
    public Teacher(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Учит студента.
     * @param student Студент.
     * @return Выпускник.
     */
    public Graduate learn(Student student) {
        return student.graduate;
    }
}