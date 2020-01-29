package ru.job4j.exam.lift;

public class DefaultShow implements IShow {

    private static final String OPEN_DOOR = "The lift opened the door.";
    private static final String CLOSE_DOOR = "The lift shut the door.";
    private static final String RIDES_LIFT = "The lift passes through floor #";
    private static final String DEST_FLOOR = "Destination floor?";

    @Override
    public String msgOpenDoor() {
        System.out.println(OPEN_DOOR);
        return OPEN_DOOR;
    }

    @Override
    public String msgCloseDoor() {
        System.out.println(CLOSE_DOOR);
        return CLOSE_DOOR;
    }

    @Override
    public String msgRidesLift(int floor) {
        String result = String.format("%s%s%n", RIDES_LIFT, floor);
        System.out.println(result);
        return result;
    }

    @Override
    public String msgQuestionDestFloor() {
        System.out.println(DEST_FLOOR);
        return DEST_FLOOR;
    }
}
