package ru.job4j.loop;

/**Построение пирамиды в псевдографике.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.09.2018
 *@version 0.1
 */
public class Paint {

    /**
     * Строит правую часть пирамиды.
     * @param height высота пирамиды.
     * @return построенная правая часть пирамиды.
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Строит левую часть пирамиды.
     * @param height высота пирамиды.
     * @return построенная левая часть пирамиды.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Строит пирамиду в псевдографике.
     * @param height высота пирамиды.
     * @return построенная пирамида.
     */
    public String piramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height * 2 - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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