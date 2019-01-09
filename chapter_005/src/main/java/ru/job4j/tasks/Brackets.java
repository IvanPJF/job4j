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
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(new BracketsPair(ch, idSymbol));
            } else if (!stack.isEmpty() && (ch == '}' || ch == ']' || ch == ')')) {
                BracketsPair delElem = stack.pop();
                char openBracket = delElem.getOpen();
                if (openBracket == '{' && ch == '}'
                        || openBracket == '[' && ch == ']'
                        || openBracket == '(' && ch == ')') {
                    delElem.setClose(ch);
                    delElem.setIdClose(idSymbol);
                    list.add(delElem);
                } else {
                    result = false;
                    break;
                }
            } else if (ch == '}' || ch == ']' || ch == ')') {
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
     * Вывод значения поля.
     * @return Список пар скобок.
     */
    public List<BracketsPair> getOutput() {
        return output;
    }
}
