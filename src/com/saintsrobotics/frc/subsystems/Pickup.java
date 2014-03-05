package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The pickup for the robot.
 * @author Saints Robotics
 */
public class Pickup extends Subsystem {
    private final SpeedController motor;
    private final DigitalInput digitalInput;
    
    public Pickup() {
        motor = new Victor(Constants.PICKUP_MOTOR_PORT);
        digitalInput = new DigitalInput(Constants.PICKUP_DIGITAL_INPUT_PORT);
    }
    
    public void pickup() {
        motor.set(Constants.PICKUP_MOTOR_POWER);
        
        updateDashboard();
    }
    
    public void reverse() {
        motor.set(-Constants.PICKUP_MOTOR_POWER);
        
        updateDashboard();
    }
    
    public void stop() {
        motor.set(0);
        
        updateDashboard();
    }
    
    public boolean isHalfLoaded() {
        return !digitalInput.get();
    }
    
    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        SmartDashboard.putBoolean("Pickup running", motor.get() != 0);
    }
}
