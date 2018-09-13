package ru.job4j.loop;

import java.util.function.BiPredicate;

/**Построение пирамиды в псевдографике.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.09.2018
 *@version 0.2
 */
public class Paint {

    /**
     * Строит правую часть пирамиды.
     * @param height высота пирамиды.
     * @return построенная правая часть пирамиды.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Строит левую часть пирамиды.
     * @param height высота пирамиды.
     * @return построенная левая часть пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Строит пирамиду в псевдографике.
     * @param height высота пирамиды.
     * @return построенная пирамида.
     */
    public String piramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Строит пирамиду.
     * @param height высота пирамиды.
     * @param weight ширина пирамиды.
     * @param predict условие проставление галки.
     * @return построенная пирамида.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}