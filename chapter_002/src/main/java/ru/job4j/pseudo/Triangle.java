package ru.job4j.pseudo;

/**Класс реализующий интерфейс Shape.
 * Для создания треугольника в виде строки.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.09.2018
 *@version 0.1
 */
public class Triangle implements Shape {

    /**
     * Создание треугольника в виде строки.
     * @return Строка символов в виде треугольника.
     */
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        StringBuilder result =
                new StringBuilder()
                        .append("  ^  ").append(ln)
                        .append(" ^^^ ").append(ln)
                        .append("^^^^^");
        return result.toString();
    }
}
