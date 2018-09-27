package ru.job4j.profession;

/**Пациент.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Patient {
    private String name;
    private Diagnose diagnose;

    public Patient() {
    }

    public Patient(String name, Diagnose diagnose) {
        this.name = name;
        this.diagnose = diagnose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}