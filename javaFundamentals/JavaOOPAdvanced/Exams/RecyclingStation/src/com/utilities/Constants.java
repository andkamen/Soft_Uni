package com.utilities;

public final class Constants {

    public static final double RECYCLING_STATION_DEFAULT_ENERGY = 0;
    public static final double RECYCLING_STATION_DEFAULT_CAPITAL = 0;


    public static final double RECYCLABLE_GARBAGE_ENERGY_PRODUCED = 0;
    public static final double BURNABLE_GARBAGE_ENERGY_PRODUCED = 1.0; // of total garbage volume
    public static final double STORABLE_GARBAGE_ENERGY_PRODUCED = 0;

    public static final double RECYCLABLE_GARBAGE_ENERGY_USED = 0.5; // of total garbage volume
    public static final double BURNABLE_GARBAGE_ENERGY_USED = 0.2;   // of total garbage volume
    public static final double STORABLE_GARBAGE_ENERGY_USED = 0.13; // of total garbage volume

    public static final double RECYCLABLE_GARBAGE_CAPITAL_EARNED = 400; // of garbage weight
    public static final double BURNABLE_GARBAGE_CAPITAL_EARNED = 0;
    public static final double STORABLE_GARBAGE_CAPITAL_EARNED = 0;

    public static final double RECYCLABLE_GARBAGE_CAPITAL_USED = 0;
    public static final double BURNABLE_GARBAGE_CAPITAL_USED = 0;
    public static final double STORABLE_GARBAGE_CAPITAL_USED = 0.65; // of total garbage volume

    public static final String INPUT_SPLIT_DELIMITER = " ";

    public static final String INPUT_COMMAND_ARGUMENTS_SPLIT_DELIMITER = "\\|";

    public static final String INPUT_TERMINATING_COMMAND = "TimeToRecycle";
}
