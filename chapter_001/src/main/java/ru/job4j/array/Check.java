package ru.job4j.array;

/**Проверка булева массива на монотонность.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class Check {

    /**
     * Проверяет массив на монотонность.
     * @param data целевой массив.
     * @return .
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 1; index < data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}