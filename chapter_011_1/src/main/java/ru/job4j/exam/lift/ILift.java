package ru.job4j.exam.lift;

public interface ILift {

    int step();

    boolean isFinish();

    void targetFloor(int targetFloor);
}
