package ru.job4j.tictactoe;

/**Проверка логики игры.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 20.09.2018
 *@version 0.1
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет наличие в поле выигрышных комбинаций для крестика.
     * @return результат проверки.
     */
    public boolean isWinnerX() {
        int size = table.length;
        boolean result;
        int count;
        result = true;
        for (int out = 1; out < size; out++) {
            if (!(table[0][0].hasMarkX() && table[out][out].hasMarkX())) {
                result = false;
                break;
            }
        }
        if (!result) {
            result = true;
            for (int out = 1; out < size; out++) {
                if (!(table[0][size - 1].hasMarkX() && table[out][size - out - 1].hasMarkX())) {
                    result = false;
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                count = 1;
                for (int in = 1; in < size; in++) {
                    if (!(table[out][0].hasMarkX() && table[out][in].hasMarkX())) {
                        result = false;
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == size) {
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                count = 1;
                for (int in = 1; in < size; in++) {
                    if (!(table[0][out].hasMarkX() && table[in][out].hasMarkX())) {
                        result = false;
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == size) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Проверяет наличие в поле выигрышных комбинаций для нолика.
     * @return результат проверки.
     */
    public boolean isWinnerO() {
        int size = table.length;
        boolean result;
        int count;
        result = true;
        for (int out = 1; out < size; out++) {
            if (!(table[0][0].hasMarkO() && table[out][out].hasMarkO())) {
                result = false;
                break;
            }
        }
        if (!result) {
            result = true;
            for (int out = 1; out < size; out++) {
                if (!(table[0][size - 1].hasMarkO() && table[out][size - out - 1].hasMarkO())) {
                    result = false;
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                count = 1;
                for (int in = 1; in < size; in++) {
                    if (!(table[out][0].hasMarkO() && table[out][in].hasMarkO())) {
                        result = false;
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == size) {
                    break;
                }
            }
        }
        if (!result) {
            for (int out = 0; out < size; out++) {
                result = true;
                count = 1;
                for (int in = 1; in < size; in++) {
                    if (!(table[0][out].hasMarkO() && table[in][out].hasMarkO())) {
                        result = false;
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == size) {
                    break;
                }
            }
        }
        return result;
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
                    break;
                }
            }
        }
        return result;
    }
}
