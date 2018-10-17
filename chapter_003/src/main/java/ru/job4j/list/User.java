package ru.job4j.list;

/**Класс с полями, для коллекции.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 17.10.2018
 *@version 0.1
 */
public class User {
    private int id;
    private String name;
    private String adress;

    public User(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }
}
