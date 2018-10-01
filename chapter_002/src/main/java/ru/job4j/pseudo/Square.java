package ru.job4j.pseudo;

/**Класс реализующий интерфейс Shape.
 * Для создания квадрата в виде строки.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.09.2018
 *@version 0.1
 */
public class Square implements Shape {

    /**
     * Создание квадрата в виде строки.
     * @return Строка символов в виде квадрата.
     */
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        StringBuilder result =
                new StringBuilder()
                        .append("*****").append(ln)
                        .append("*****").append(ln)
                        .append("*****");
        return result.toString();
    }
}
