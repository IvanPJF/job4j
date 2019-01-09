package ru.job4j.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Анаграмма.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.01.2019
 *@version 0.1
 */
public class Anagram {

    /**
     * Проверка двух слов на принадлежность к анаграммам.
     * @param str1 Первое слово.
     * @param str2 Второе слово.
     * @return Логический результат.
     */
    public boolean checkAnagram(String str1, String str2) {
        return str1.length() == str2.length()
                && toHashMap(str1).equals(toHashMap(str2));
    }

    /**
     * Деление слова на символы и добавление их в HashMap.
     * @param value
     * @return
     */
    private Map<Character, Integer> toHashMap(String value) {
        Map<Character, Integer> map = new HashMap<>(value.length());
        value = value.toLowerCase();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            Integer count = map.get(ch);
            map.put(ch, count == null ? 1 : ++count);
        }
        return map;
    }
}
