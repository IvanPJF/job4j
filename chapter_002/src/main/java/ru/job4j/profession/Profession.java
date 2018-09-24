package ru.job4j.profession;

/**Класс профессия.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Profession {
    public String name;
    public String profession;

    public Profession() {
    }

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Возвращает значение поля "name".
     * @return Значение поля "name".
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает значение поля "profession".
     * @return Значение поля "profession".
     */
    public String getProfession() {
        return this.profession;
    }
}