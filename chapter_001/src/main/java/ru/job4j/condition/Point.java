package ru.job4j.condition;

/**Расстояние между точками.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2018
 *@version 0.2
 */
public class Point {
    //Поля объекта.
    private int x;
    private int y;
    //Конструктор координат точки.
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Рассчитываем расстояние между двумя точками.
     * @param that вторая точка.
     * @return Расстояние между двумя точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2)
        );
    }
}
