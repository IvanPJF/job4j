package ru.job4j.pseudo;

/**Класс вывода на консоль.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.09.2018
 *@version 0.1
 */
public class Paint {

    /**
     * Вывод на консоль возвращаемых значений метода draw интерфейса Shape.
     * @param shape Экземпляр класса, реализующего интерфейс Shape.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Вывод на консоль строк в виде треугольника и квадрата.
     * @param args массив строк.
     */
    public static void main(String[] args) {
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}
