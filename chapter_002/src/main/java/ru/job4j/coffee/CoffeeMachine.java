package ru.job4j.coffee;

import java.util.Arrays;

/**Кофемашина.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.10.2018
 *@version 0.1
 */
public class CoffeeMachine {
    private final int[] coins = {10, 5, 2, 1};

    /**
     * Расчет сдачи.
     * @param value Купюра.
     * @param price Цена кофе.
     * @return Сдача.
     */
    public int[] changes(int value, int price) {
        int[] result = {};
        int change = value - price;
        int temp, tempAll = 0;
        for (int coin : this.coins) {
            if (change / coin != 0) {
                temp = change / coin;
                tempAll += temp;
                change = change % coin;
                result = Arrays.copyOf(result, tempAll);
                for (int in = tempAll - temp; in < tempAll; in++) {
                    result[in] = coin;
                }
            }
        }
        return result;
    }
}
