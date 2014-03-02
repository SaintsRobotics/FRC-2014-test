package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The gear shifter for the robot.
 * @author Saints Robotics
 */
public class GearShifter extends Subsystem {
    private final SpeedController motor;
    
    public GearShifter() {
        motor = new Victor(Constants.GEAR_SHIFTER_MOTOR_PORT);
    }
    
    /**
     * Shift the gear up to high gear.
     */
    public void shiftToHighGear() {
        motor.set(Constants.GEAR_SHIFTER_MOTOR_POWER);
        
        updateDashboard();
    }
    
    /**
     * Shift the gear down to low gear.
     */
    public void shiftToLowGear() {
        motor.set(-Constants.GEAR_SHIFTER_MOTOR_POWER);
        
        updateDashboard();
    }
    
    /**
     * Stop shifting gears.
     */
    public void stop() {
        motor.set(0);
        
        updateDashboard();
    }

    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        boolean isShiftingGears = (motor.get() != 0);
        SmartDashboard.putBoolean("Gear shifter running", isShiftingGears);
    }
}
