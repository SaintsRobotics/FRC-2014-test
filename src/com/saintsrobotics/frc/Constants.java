package com.saintsrobotics.frc;

import com.saintsrobotics.frc.utilities.XboxAxis;
import com.saintsrobotics.frc.utilities.XboxButton;
import edu.wpi.first.wpilibj.Relay;

/**
 * A comprehensive list of the constants used by our robot.
 * @author Saints Robotics
 */
public class Constants {
    // Motor mappings
    public static final int LEFT_MOTOR_1_PORT = 1;
    public static final int LEFT_MOTOR_2_PORT = 2;
    
    public static final int RIGHT_MOTOR_1_PORT = 3;
    public static final int RIGHT_MOTOR_2_PORT = 4;
    
    public static final boolean SQUARED_INPUTS = true;
    
    // Relay mappings
    public static final int PICKUP_RELAY_PORT = 2;
    public static final Relay.Direction PICKUP_RELAY_DIRECTION =
            Relay.Direction.kBoth;
    
    public static final int SHOOTER_RELAY_PORT = 1;
    public static final Relay.Direction SHOOTER_RELAY_DIRECTION =
            Relay.Direction.kForward;
    
    public static final int GEAR_SHIFTER_MOTOR_PORT = 10;
    public static final double GEAR_SHIFTER_MOTOR_POWER = 1;
    
    // Digital input mappings
    public static final int PICKUP_DIGITAL_INPUT_PORT = 2;
    public static final int SHOOTER_DIGITAL_INPUT_PORT = 1;
    
    // Joystick control
    public static final double XBOX_DEAD_ZONE = 0.13;
    
    public static final double DRIVE_JOYSTICK_DEAD_ZONE = XBOX_DEAD_ZONE;
    public static final int DRIVE_JOYSTICK_PORT = 1;
    
    public static final int OPERATOR_JOYSTICK_PORT = 2;
    
    public static final int DRIVE_SLOW_MODE_FACTOR = 7;
    public static final boolean DRIVE_INVERTED = true;
    
    public static final XboxAxis ARCADE_MOVE_JOYSTICK_AXIS = XboxAxis.LEFT_THUMB_Y;
    public static final boolean ARCADE_MOVE_JOYSTICK_INVERTED = DRIVE_INVERTED;
    
    public static final XboxAxis ARCADE_ROTATE_JOYSTICK_AXIS = XboxAxis.RIGHT_THUMB_X;
    public static final boolean ARCADE_ROTATE_JOYSTICK_INVERTED = true;
    
    public static final XboxAxis TANK_LEFT_JOYSTICK_AXIS = XboxAxis.LEFT_THUMB_Y;
    public static final boolean TANK_LEFT_JOYSTICK_INVERTED = DRIVE_INVERTED;
    
    public static final XboxAxis TANK_RIGHT_JOYSTICK_AXIS = XboxAxis.RIGHT_THUMB_Y;
    public static final boolean TANK_RIGHT_JOYSTICK_INVERTED = DRIVE_INVERTED;
    
    // Button mappings
    public static final XboxButton SLOW_MODE_BUTTON = XboxButton.LEFT_BUMPER;
    public static final XboxButton SHIFT_GEAR_DOWN_BUTTON = XboxButton.RIGHT_BUMPER;
    public static final XboxButton SHIFT_GEAR_UP_BUTTON = XboxButton.Y;
    
    public static final XboxButton PICKUP_BUTTON = XboxButton.RIGHT_BUMPER;
    public static final XboxButton RELEASE_PICKUP_BUTTON = XboxButton.LEFT_BUMPER;
    public static final XboxButton SHOOT_WITH_RESET_BUTTON = XboxButton.A;
    public static final XboxButton SHOOT_WITHOUT_RESET_BUTTON = XboxButton.X;
    public static final XboxButton STOP_SHOOT_BUTTON = XboxButton.B;
    
    /**
     * Disallow instantiation.
     */
    private Constants() {}
}
