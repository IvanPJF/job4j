package ru.job4j.loop;

/**Построение шахматной доски в псевдографике.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.09.2018
 *@version 0.1
 */
public class Board {

    /**
     * Строит шахматную доску в псевдографике.
     * @param width ширина доски.
     * @param height высота доски.
     * @return построенная доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}