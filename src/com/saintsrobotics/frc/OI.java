package com.saintsrobotics.frc;

import com.saintsrobotics.frc.commands.*;
import com.saintsrobotics.frc.utilities.XboxAxis;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Saints Robotics
 */
public class OI {
    private final Joystick driveJoystick;
    private final Joystick operatorJoystick;
    
    private boolean driveSlowMode;
    
    public OI() {
        // Drive joystick
        driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);
        
        JoystickButton shiftGearDownButton = new JoystickButton(driveJoystick,
                Constants.SHIFT_GEAR_DOWN_BUTTON.value);
        shiftGearDownButton.whenPressed(new ShiftToLowGear());
        shiftGearDownButton.whenReleased(new StopShiftGear());
        
        JoystickButton shiftGearUpButton = new JoystickButton(driveJoystick,
                Constants.SHIFT_GEAR_UP_BUTTON.value);
        shiftGearUpButton.whenPressed(new ShiftToHighGear());
        shiftGearUpButton.whenReleased(new StopShiftGear());
        
        JoystickButton slowModeButton = new JoystickButton(driveJoystick,
                Constants.SLOW_MODE_BUTTON.value);
        slowModeButton.whenPressed(new ToggleDriveSlowMode());
        slowModeButton.whenReleased(new ToggleDriveSlowMode());
        
        // Operator joystick
        operatorJoystick = new Joystick(Constants.OPERATOR_JOYSTICK_PORT);
        
        JoystickButton pickupButton = new JoystickButton(operatorJoystick,
                Constants.PICKUP_BUTTON.value);
        pickupButton.whenPressed(new PickupBall());
        pickupButton.whenReleased(new StopPickupBall());
        
        JoystickButton releasePickupButton = new JoystickButton(operatorJoystick,
                Constants.RELEASE_PICKUP_BUTTON.value);
        releasePickupButton.whenPressed(new ReleasePickupBall());
        releasePickupButton.whenReleased(new StopPickupBall());
        
        JoystickButton shootWithResetButton = new JoystickButton(operatorJoystick,
                Constants.SHOOT_WITH_RESET_BUTTON.value);
        shootWithResetButton.whenPressed(new ShootBallWithReset());
        
        JoystickButton shootWithoutResetButton = new JoystickButton(operatorJoystick,
                Constants.SHOOT_WITHOUT_RESET_BUTTON.value);
        shootWithoutResetButton.whenPressed(new ShootBallWithoutReset());
        
        JoystickButton stopShootButton = new JoystickButton(operatorJoystick,
                Constants.STOP_SHOOT_BUTTON.value);
        stopShootButton.whenPressed(new StopShootBall());
    }
    
    public double getArcadeMoveJoy() {
        double axisValue = readAxisValue(Constants.ARCADE_MOVE_JOYSTICK_AXIS,
                Constants.DRIVE_JOYSTICK_DEAD_ZONE,
                Constants.ARCADE_MOVE_JOYSTICK_INVERTED);
        
        return adjustDriveValue(axisValue);
    }
    
    public double getArcadeRotateJoy() {
        double axisValue = readAxisValue(Constants.ARCADE_ROTATE_JOYSTICK_AXIS,
                Constants.DRIVE_JOYSTICK_DEAD_ZONE,
                Constants.ARCADE_ROTATE_JOYSTICK_INVERTED);
        
        return adjustDriveValue(axisValue);
    }
    
    public double getTankLeftJoy() {
        double axisValue = readAxisValue(Constants.TANK_LEFT_JOYSTICK_AXIS,
                Constants.DRIVE_JOYSTICK_DEAD_ZONE,
                Constants.TANK_LEFT_JOYSTICK_INVERTED);
        
        return adjustDriveValue(axisValue);
    }
    
    public double getTankRightJoy() {
        double axisValue = readAxisValue(Constants.TANK_RIGHT_JOYSTICK_AXIS,
                Constants.DRIVE_JOYSTICK_DEAD_ZONE,
                Constants.TANK_RIGHT_JOYSTICK_INVERTED);
        
        return adjustDriveValue(axisValue);
    }
    
    public boolean isDriveSlowMode() {
        return driveSlowMode;
    }
    
    public void setDriveSlowMode(boolean driveSlowMode) {
        this.driveSlowMode = driveSlowMode;
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
    
    private double adjustDriveValue(double value) {
        // Slow mode
        if (driveSlowMode) {
            value /= Constants.DRIVE_SLOW_MODE_FACTOR;
        }
        
        return value;
    }
    
    private double deadZone(double value, double deadZone) {
        if (Math.abs(value) < deadZone) {
            return 0;
        }
        
        return value;
    }
}

