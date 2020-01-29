package ru.job4j.exam.lift;

import org.apache.commons.cli.*;

public class ParserArgs {

    private CommandLine commandLine;
    private static final String COUNT_FLOOR_OPTION = "c";
    private static final String HEIGHT_FLOOR_OPTION = "h";
    private static final String SPEED_LIFT_OPTION = "s";
    private static final String DOOR_TIME_OPTION = "o";
    private int countFloors;
    private int heightFloor;
    private int speedLift;
    private int openDoorTime;

    public ParserArgs(String[] args) {
        parseArgsToParametersLift(args);
    }

    private void parseArgsToParametersLift(String[] args) {
        Options options = new Options();
        options.addOption(new Option(COUNT_FLOOR_OPTION, true, "Count floor"));
        options.addOption(new Option(HEIGHT_FLOOR_OPTION, true, "Height floor"));
        options.addOption(new Option(SPEED_LIFT_OPTION, true, "Speed lift"));
        options.addOption(new Option(DOOR_TIME_OPTION, true, "Open door time"));
        try {
            this.commandLine = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        countFloors = getValueByOption(COUNT_FLOOR_OPTION);
        heightFloor = getValueByOption(HEIGHT_FLOOR_OPTION);
        speedLift = getValueByOption(SPEED_LIFT_OPTION);
        openDoorTime = getValueByOption(DOOR_TIME_OPTION);
    }

    private Integer getValueByOption(String option) {
        Integer result = null;
        if (this.commandLine.hasOption(option)) {
            result = Integer.parseInt(commandLine.getOptionValue(option));
        }
        return result;
    }

    public int getCountFloors() {
        return countFloors;
    }

    public int getHeightFloor() {
        return heightFloor;
    }

    public int getSpeedLift() {
        return speedLift;
    }

    public int getOpenDoorTime() {
        return openDoorTime;
    }
}
