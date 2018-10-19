package ru.job4j.comparator;

import java.util.Comparator;

/**Компаратор для сравнения двух строк.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.10.2018
 *@version 0.1
 */
public class ListCompare implements Comparator<String> {

    /**
     * Компаратор для двух строк.
     * @param left первая строка.
     * @param right вторая строка.
     * @return результат сравнения.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            result = Character.compare(
                    left.charAt(i), right.charAt(i)
            );
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? Integer.compare(left.length(), right.length()) : result;
    }
}