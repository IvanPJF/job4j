package ru.job4j.tictactoe;

public abstract class BasePlayer implements IPlayer {

    private final String mark;
    private final String name;

    public BasePlayer(String mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    @Override
    public String getMark() {
        return this.mark;
    }

    @Override
    public String toString() {
        return String.format("mark='%s', name='%s'", mark, name);
    }
}
