package ru.job4j.array;

/**Заполнение массива степенями чисел.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 13.09.2018
 *@version 0.1
 */
public class Square {

    /**
     * Заполняет массив степенями чисел.
     * @param bound размер массива.
     * @return заполненный массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}
