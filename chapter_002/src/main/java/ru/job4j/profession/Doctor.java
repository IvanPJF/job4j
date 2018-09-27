package ru.job4j.profession;

/**Доктор, лечит пациентов.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 24.09.2018
 *@version 0.1
 */
public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Лечит пациента.
     * @param patient Пациент.
     * @return Диагноз.
     */
    public Diagnose heal(Patient patient) {
        return patient.getDiagnose();
    }
}