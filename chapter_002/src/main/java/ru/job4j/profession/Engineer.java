package ru.job4j.profession;

/**Инженер, строит дома.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Engineer extends Profession {
    public Engineer(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Строит дом.
     * @param construction Работа инженера.
     * @return Дом.
     */
    public House build(Construction construction) {
        return construction.house;
    }
}