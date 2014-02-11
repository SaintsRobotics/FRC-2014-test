package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import utilities.XboxButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Saints Robotics
 */
public class OI {
    // Constants
    private static final double DRIVE_JOYSTICK_DEAD_ZONE = 0.13;
    private static final int DRIVE_JOYSTICK_PORT = 1;
    
    private static final int ARCADE_MOVE_JOYSTICK_AXIS = 2;
    private static final int ARCADE_ROTATE_JOYSTICK_AXIS = 4;
    private static final boolean ARCADE_ROTATE_JOYSTICK_INVERTED = true;
    
    private static final int TANK_LEFT_JOYSTICK_AXIS = 2;
    private static final int TANK_RIGHT_JOYSTICK_AXIS = 5;
    
    private static final int PICKUP_JOYSTICK_AXIS = 3;
    private static final XboxButton DRIVE_MODE_BUTTON = XboxButton.X;
    
    // Instance members
    private final Joystick driveJoystick;
    private final JoystickButton driveModeButton;
    
    public OI() {
        driveJoystick = new Joystick(DRIVE_JOYSTICK_PORT);
        driveModeButton = new JoystickButton(driveJoystick, DRIVE_MODE_BUTTON.value);
    }
    
    public double getArcadeMoveJoy() {
        return readAxisValue(ARCADE_MOVE_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE);
    }
    
    public double getArcadeRotateJoy() {
        return readAxisValue(ARCADE_ROTATE_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE,
                ARCADE_ROTATE_JOYSTICK_INVERTED);
    }
    
    public double getTankLeftJoy() {
        return readAxisValue(TANK_LEFT_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE);
    }
    
    public double getTankRightJoy() {
        return readAxisValue(TANK_RIGHT_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE);
    }
    
    public double getPickupJoy() {
        return readAxisValue(PICKUP_JOYSTICK_AXIS);
    }
    
    private double readAxisValue(int axis) {
        return readAxisValue(axis, 0);
    }
    
    private double readAxisValue(int axis, double deadZone) {
        return readAxisValue(axis, deadZone, false);
    }
    
    private double readAxisValue(int axis, double deadZone, boolean inverted) {
        double value = driveJoystick.getRawAxis(axis);
        
        if (inverted) {
            value = -value;
        }
        
        value = deadZone(value, deadZone);
        
        return value;
    }
    
    private double deadZone(double value, double deadZone) {
        if (Math.abs(value) < deadZone) {
            return 0;
        }
        
        return value;
    }
}

