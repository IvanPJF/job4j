package ru.job4j.array;

/**Проверка начала слова в определенной последовательности.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2018
 *@version 0.1
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет совпадение слова с префиксом.
     * @param prefix префикс.
     * @return Результат проверки совпадения префикса со словом.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (value[index] != this.data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}