package com.saintsrobotics.frc;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Motors
    public static final int LEFT_MOTOR = 2;
    public static final int RIGHT_MOTOR = 4;
    public static final int PICKUP_MOTOR = 3;
    
    // Joysticks
    public static final int JOYSTICK = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
