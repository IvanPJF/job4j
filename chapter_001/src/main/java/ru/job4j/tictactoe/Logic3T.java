package ru.job4j.tictactoe;

/**Проверка логики игры.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 20.09.2018
 *@version 0.3
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет наличие в поле выигрышных комбинаций.
     * @param forX выбор победы, true - для крестиков, false - для ноликов
     * @return результат проверки.
     */
    public boolean isWin(boolean forX) {
        int size = table.length;
        boolean result = true;
        boolean[][] winCell = new boolean[size][size];
        for (int out = 0; out < size; out++) {
            for (int in = 0; in < size; in++) {
                if (forX) {
                    winCell[out][in] = table[out][in].hasMarkX();
                } else {
                    winCell[out][in] = table[out][in].hasMarkO();
                }
            }
        }
        for (int out = 0; out < size; out++) {
            if (!winCell[out][out]) {
                result = false;
                break;
            }
        }
        if (!result) {
            result = true;
            for (int out = 0; out < size; out++) {
                if (!winCell[out][size - out - 1]) {
                    result = false;
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                for (int in = 0; in < size; in++) {
                    if (!winCell[out][in]) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                for (int in = 0; in < size; in++) {
                    if (!winCell[in][out]) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Проверяет наличие в поле выигрышных комбинаций для крестика.
     * @return результат проверки.
     */
    public boolean isWinnerX() {
        return isWin(true);
    }

    /**
     * Проверяет наличие в поле выигрышных комбинаций для нолика.
     * @return результат проверки.
     */
    public boolean isWinnerO() {
        return isWin(false);
    }

    /**
     * Проверяет наличие пустых клеток для ходов.
     * @return результат проверки.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int out = 0; out < table.length; out++) {
            for (int in = 0; in < table.length; in++) {
                if (!(table[out][in].hasMarkX())
                        && !(table[out][in].hasMarkO())) {
                    result = true;
                    out = table.length;
                    break;
                }
            }
        }
        return result;
    }
}
