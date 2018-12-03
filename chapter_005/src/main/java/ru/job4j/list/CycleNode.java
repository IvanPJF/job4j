package ru.job4j.list;

/**
 * Класс для определения цикличности связного списка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 30.11.2018
 *@version 0.1
 */
public class CycleNode {

    /**
     * Определение цикличности связанного списка.
     * @param first Элемент для старта проверки.
     * @return Результат: true - список цикличен, false - список не цикличен.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        if (first != null) {
            Node turtle = first;
            Node hare = first;
            while (hare.next != null && hare.next.next != null) {
                turtle = turtle.next;
                hare = hare.next.next;
                if (turtle == hare) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
