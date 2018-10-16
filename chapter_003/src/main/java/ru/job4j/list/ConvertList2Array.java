package ru.job4j.list;

import java.util.List;

/**Конвертация ArrayList в массив.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.10.2018
 *@version 0.1
 */
public class ConvertList2Array {

    /**
     * Метод конвретирует список в массив.
     * @param list список для конвертации в массив.
     * @param rows количество строк массива.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] result = new int[rows][cells];
        int out = 0, in = 0;
        for (Integer value : list) {
            if (in != cells) {
                result[out][in++] = value;
            } else if (out != rows) {
                in = 0;
                result[++out][in++] = value;
            }
        }
        return result;
    }

}