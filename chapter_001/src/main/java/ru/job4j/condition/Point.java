package ru.job4j.condition;

/**Расстояние между точками.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.09.2018
 *@version 0.1
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

    /**
     * Тестовый запуск с выводом результата на консоль.
     * @param args args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вывод на консоль.
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        System.out.println("Расстояние между точками А и В : " + a.distanceTo(b));
    }
}
