package ru.job4j.profession;

/**Работа инженера.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Construction {
    private String name;
    private House house;

    public Construction() {
    }

    public Construction(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}