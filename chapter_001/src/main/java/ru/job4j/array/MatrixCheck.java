package ru.job4j.array;

/**Проверка квадратного массива на монотонность диагоналей.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class MatrixCheck {

    /**
     * Проверяем массив на монотонность диагоналей.
     * @param data целевой массив.
     * @return Результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (data[i][i] != data[0][0]) {
                    result = false;
                    break;
                }
                if ((i + j) == size - 1) {
                    if (data[i][j] != data[0][size - 1]) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
