package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static final double DRIVE_JOYSTICK_DEAD_ZONE = 0.13;
    private static final double NO_DEAD_ZONE = 0;
    private static final int ARCADE_MOVE_JOYSTICK_AXIS = 2;
    private static final boolean ARCADE_MOVE_JOYSTICK_INVERTED = false;
    private static final int ARCADE_ROTATE_JOYSTICK_AXIS = 4;
    private static final boolean ARCADE_ROTATE_JOYSTICK_INVERTED = true;
    private static final int PICKUP_JOYSTICK_AXIS = 3;
    private static final boolean PICKUP_JOYSTICK_INVERTED = false;
    private final Joystick driveJoystick;
    
    public OI() {
        driveJoystick = new Joystick(RobotMap.JOYSTICK);
    }
    
    public double getArcadeMoveJoy() {
        return readAxisValue(ARCADE_MOVE_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE,
                ARCADE_MOVE_JOYSTICK_INVERTED);
    }
    
    public double getArcadeRotateJoy() {
        return readAxisValue(ARCADE_ROTATE_JOYSTICK_AXIS,
                DRIVE_JOYSTICK_DEAD_ZONE,
                ARCADE_ROTATE_JOYSTICK_INVERTED);
    }
    
    public double getPickupJoy() {
        return readAxisValue(PICKUP_JOYSTICK_AXIS,
                NO_DEAD_ZONE,
                PICKUP_JOYSTICK_INVERTED);
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

