package ru.job4j.tasks;

import java.util.*;

/**
 * Парсинг скобок.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.01.2019
 *@version 0.1
 */
public class Brackets {

    private List<BracketsPair> output;
    private char[] arrOpen = {'{', '[', '(', 's'};
    private char[] arrClose = {'}', ']', ')', 'f'};

    /**
     * Проверка валидности скобок.
     * При правильной расстановке скобок в строке, полю output присваивается список пар скобок с их позициями.
     * @param str Проверяемая строка, содержащая скобки.
     * @return Логический результат проверки.
     */
    public boolean bracketsValid(String str) {
        Deque<BracketsPair> stack = new LinkedList<>();
        List<BracketsPair> list = new ArrayList<>(str.length());
        boolean result = true;
        for (int idSymbol = 0; idSymbol < str.length(); idSymbol++) {
            char ch = str.charAt(idSymbol);
            if (this.findBracket(ch, this.arrOpen)) {
                stack.push(new BracketsPair(ch, idSymbol));
            } else if (!stack.isEmpty() && this.findBracket(ch, this.arrClose)) {
                BracketsPair delElem = stack.pop();
                if (this.closeBrackets(ch, delElem)) {
                    delElem.setClose(ch);
                    delElem.setIdClose(idSymbol);
                    list.add(delElem);
                } else {
                    result = false;
                    break;
                }
            } else if (this.findBracket(ch, this.arrClose)) {
                result = false;
                break;
            }
        }
        if (!stack.isEmpty()) {
            list = null;
            result = false;
        }
        this.output = list;
        return result;
    }

    /**
     * Проверка символа строки, является ли он скобкой(одним из элементов массива скобок).
     * @param ch Проверяемый символ.
     * @param arrBrackets Массив скобок.
     * @return Логический результат проверки.
     */
    private boolean findBracket(char ch, char[] arrBrackets) {
        boolean result = false;
        for (char value : arrBrackets) {
            if (ch == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Проверка символа строки, является ли он закрывающей скобкой,
     *          и есть ли для него соответствующая открывающая скобка.
     * @param ch Проверяемый символ.
     * @param bracketsPair Переменная, содержащая пару скобок с их индексами.
     * @return Логический результат проверки.
     */
    private boolean closeBrackets(char ch, BracketsPair bracketsPair) {
        boolean result = false;
        for (int i = 0; i < this.arrClose.length; i++) {
            if (ch == this.arrClose[i] && bracketsPair.getOpen() == this.arrOpen[i]) {
                result = true;
                break;
            }
        }
        return result;
    }

    public List<BracketsPair> getOutput() {
        return output;
    }
}
