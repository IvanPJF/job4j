package ru.job4j.array;

/**Создание таблицы умножения.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class Matrix {

    /**
     * Создаём таблицу умножения.
     * @param size размер таблицы умножения.
     * @return Таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (j + 1) * (i + 1);
            }
        }
        return table;
    }
}
