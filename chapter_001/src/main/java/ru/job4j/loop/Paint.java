package ru.job4j.loop;

/**Построение пирамиды в псевдографике.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.09.2018
 *@version 0.1
 */
public class Paint {

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