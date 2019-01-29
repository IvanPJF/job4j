package ru.job4j.inputoutput;

import java.io.IOException;
import java.io.InputStream;

/**
 * Чётное число в потоке.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.01.2019
 *@version 0.1
 */
public class IsEvenNumber {

    /**
     * Определяет, является ли число в потоке чётным.
     * @param in Входной поток.
     * @return Логический результат проверки.
     */
    public boolean isNumber(InputStream in) {
        boolean result = true;
        StringBuilder number = new StringBuilder();
        try (InputStream is = in) {
            int readChar = -1;
            char currentChar = 0;
            while ((readChar = is.read()) != -1) {
                currentChar = (char) readChar;
                if (currentChar < '0' || currentChar > '9') {
                    result = false;
                    break;
                }
                number.append(currentChar);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result && Integer.valueOf(number.toString()) % 2 == 0;
    }
}
