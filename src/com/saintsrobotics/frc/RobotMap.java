package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.Relay;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Motors
    public static final int LEFT_MOTOR_1 = 1;
    public static final int LEFT_MOTOR_2 = 2;
    
    public static final int RIGHT_MOTOR_1 = 3;
    public static final int RIGHT_MOTOR_2 = 4;
    
    // Relays
    public static final int PICKUP_RELAY = 5;
    public static final Relay.Direction PICKUP_RELAY_DIRECTION = Relay.Direction.kBoth;
    
    public static final int SHOOTER_RELAY = 6;
    public static final Relay.Direction SHOOTER_RELAY_DIRECTION = Relay.Direction.kBoth;
}
