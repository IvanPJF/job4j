package ru.job4j.tasks;

/**
 * Пара скобок.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.01.2019
 *@version 0.1
 */
public class BracketsPair {

    private char open;
    private int idOpen;
    private char close;
    private int idClose;

    public BracketsPair(char open, int idOpen) {
        this.open = open;
        this.idOpen = idOpen;
    }

    public void setClose(char close) {
        this.close = close;
    }

    public void setIdClose(int idClose) {
        this.idClose = idClose;
    }

    public char getOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "Brackets{"
                + "open=" + open
                + ", id=" + idOpen
                + ", close=" + close
                + ", id=" + idClose
                + '}';
    }
}
