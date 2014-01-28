package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static final double DRIVE_JOYSTICK_DEAD_ZONE = 0.13;
    private static final int ARCADE_THROTTLE_JOYSTICK_AXIS = 2;
    private static final int ARCADE_TURN_JOYSTICK_AXIS = 4;
    private static final int PICKUP_JOYSTICK_AXIS = 3;
    private final Joystick driveJoystick;
    
    public OI() {
        driveJoystick = new Joystick(RobotMap.JOYSTICK);
    }
    
    public double getDriveJoyY() {
        double value = driveJoystick.getRawAxis(ARCADE_THROTTLE_JOYSTICK_AXIS);
        value = deadZone(value, DRIVE_JOYSTICK_DEAD_ZONE);
        return value;
    }
    
    public double getDriveJoyX() {
        double value = driveJoystick.getRawAxis(ARCADE_TURN_JOYSTICK_AXIS);
        value = deadZone(value, DRIVE_JOYSTICK_DEAD_ZONE);
        return value;
    }
    
    public double getPickupJoy() {
        double value = driveJoystick.getRawAxis(PICKUP_JOYSTICK_AXIS);
        //value = deadZone(value, DRIVE_JOYSTICK_DEAD_ZONE);
        return value;
    }
    
    private double deadZone(double value, double deadZone) {
        if (Math.abs(value) < deadZone) {
            return 0;
        }
        
        return value;
    }
}

