package ru.job4j.department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public List<String> createList(String[] array) {
        List<String> list = Arrays.asList(array);
        List<String> result = new ArrayList<>();
        list.forEach(
                value -> {
                    int index = value.lastIndexOf("\\");
                    if (index != -1) {
                        String sub = value.substring(0, index);
                        if (!list.contains(sub) && !result.contains(sub)) {
                            result.add(sub);
                        }
                    }
                }
        );
        result.addAll(list);
        return result;
    }

    /**
     * Сортировка по возрастанию.
     * @param array Неотсортированный массив.
     * @return Отсортированный массив.
     */
    public String[] sortUp(String[] array) {
        return createList(array).stream().sorted().toArray(String[]::new);
    }

    /**
     * Сортировка по убыванию.
     * @param array Неотсортированный массив.
     * @return Отсортированный массив.
     */
    public String[] sortDown(String[] array) {
        List<String> list = createList(array);
        list.sort(
                (o1, o2) -> {
                    int value = o2.compareTo(o1);
                    return value == -1 ? value : Integer.compare(o1.length(), o2.length());
                }
        );
        return list.toArray(new String[0]);
    }
}
