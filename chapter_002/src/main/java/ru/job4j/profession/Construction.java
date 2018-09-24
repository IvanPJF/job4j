package ru.job4j.profession;

/**Работа инженера.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Construction {
    public String name;
    public House house;

    public Construction() {
    }

    public Construction(String name, House house) {
        this.name = name;
        this.house = house;
    }
}