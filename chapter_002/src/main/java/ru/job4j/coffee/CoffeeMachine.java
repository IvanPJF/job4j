package ru.job4j.coffee;

/**Кофемашина.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 08.10.2018
 *@version 0.1
 */
public class CoffeeMachine {
    private static final int TEN = 10;
    private static final int FIVE = 5;
    private static final int TWO = 2;
    private static final int ONE = 1;

    /**
     * Расчет сдачи.
     * @param value Купюра.
     * @param price Цена кофе.
     * @return Сдача.
     */
    public int[] changes(int value, int price) {
        int mix = value - price;
        int ten = mix / TEN;
        mix = mix % TEN;
        int five = mix / FIVE;
        mix = mix % FIVE;
        int two = mix / TWO;
        mix = mix % TWO;
        int one = mix / ONE;
        int[] change = new int[ten + five + two + one];
        for (int out = 0; out < change.length; out++) {
            if (ten > 0) {
                change[out] = TEN;
                ten--;
            } else if (five > 0) {
                change[out] = FIVE;
                five--;
            } else if (two > 0) {
                change[out] = TWO;
                two--;
            } else {
                change[out] = ONE;
                one--;
            }
        }
        return change;
    }
}
