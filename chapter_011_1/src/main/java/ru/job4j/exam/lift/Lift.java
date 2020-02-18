package ru.job4j.exam.lift;

public class Lift implements ILift {

    private int currentFloor;
    private int targetFloor;

    public Lift(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public int step() {
        int step = Integer.compare(this.targetFloor, this.currentFloor);
        this.currentFloor += step;
        return this.currentFloor;
    }

    @Override
    public boolean isFinish() {
        return this.currentFloor == this.targetFloor;
    }

    @Override
    public void targetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }
}
