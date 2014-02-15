package com.saintsrobotics.frc;

import com.saintsrobotics.frc.commands.*;
import com.saintsrobotics.frc.utilities.XboxAxis;
import com.saintsrobotics.frc.utilities.XboxButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Saints Robotics
 */
public class OI {
    // Constants
    private static final double DRIVE_JOYSTICK_DEAD_ZONE = 0.13;
    private static final int DRIVE_JOYSTICK_PORT = 1;
    
    private static final XboxAxis ARCADE_MOVE_JOYSTICK_AXIS = XboxAxis.LEFT_THUMB_Y;
    private static final XboxAxis ARCADE_ROTATE_JOYSTICK_AXIS = XboxAxis.RIGHT_THUMB_X;
    private static final boolean ARCADE_ROTATE_JOYSTICK_INVERTED = true;
    
    private static final XboxAxis TANK_LEFT_JOYSTICK_AXIS = XboxAxis.LEFT_THUMB_Y;
    private static final XboxAxis TANK_RIGHT_JOYSTICK_AXIS = XboxAxis.RIGHT_THUMB_Y;
    
    private static final XboxButton PICKUP_BUTTON = XboxButton.RIGHT_BUMPER;
    private static final XboxButton RELEASE_PICKUP_BUTTON = XboxButton.LEFT_BUMPER;
    private static final XboxButton SHOOT_BUTTON = XboxButton.A;
    private static final XboxButton SHIFT_GEAR_UP_BUTTON = XboxButton.B;
    private static final XboxButton SHIFT_GEAR_DOWN_BUTTON = XboxButton.X;
    
    // Instance members
    private final Joystick driveJoystick;
    private final JoystickButton pickupButton;
    private final JoystickButton releasePickupButton;
    private final JoystickButton shootButton;
    private final JoystickButton shiftGearUpButton;
    private final JoystickButton shiftGearDownButton;
    
    public OI() {
        driveJoystick = new Joystick(DRIVE_JOYSTICK_PORT);
        
        pickupButton = new JoystickButton(driveJoystick, PICKUP_BUTTON.value);
        pickupButton.whenPressed(new PickupBall());
        pickupButton.whenReleased(new StopPickupBall());
        
        releasePickupButton = new JoystickButton(driveJoystick,
                RELEASE_PICKUP_BUTTON.value);
        releasePickupButton.whenPressed(new ReleasePickupBall());
        releasePickupButton.whenReleased(new StopPickupBall());
        
        shootButton = new JoystickButton(driveJoystick, SHOOT_BUTTON.value);
        shootButton.whenPressed(new ShootBall());
        shootButton.whenReleased(new StopShootBall());
        
        shiftGearUpButton = new JoystickButton(driveJoystick,
                SHIFT_GEAR_UP_BUTTON.value);
        shiftGearUpButton.whenPressed(new ShiftGearUp());
        shiftGearUpButton.whenReleased(new StopShiftGear());
        
        shiftGearDownButton = new JoystickButton(driveJoystick,
                SHIFT_GEAR_DOWN_BUTTON.value);
        shiftGearDownButton.whenPressed(new ShiftGearDown());
        shiftGearDownButton.whenReleased(new StopShiftGear());
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
    
    private double readAxisValue(XboxAxis axis) {
        return readAxisValue(axis, 0);
    }
    
    private double readAxisValue(XboxAxis axis, double deadZone) {
        return readAxisValue(axis, deadZone, false);
    }
    
    private double readAxisValue(XboxAxis axis, double deadZone, boolean inverted) {
        int axisValue = axis.value;
        double value = driveJoystick.getRawAxis(axisValue);
        
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

