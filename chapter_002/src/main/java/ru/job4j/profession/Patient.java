package ru.job4j.profession;

/**Пациент.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Patient {
    public String name;
    public Diagnose diagnose;

    public Patient() {
    }

    public Patient(String name, Diagnose diagnose) {
        this.name = name;
        this.diagnose = diagnose;
    }
}