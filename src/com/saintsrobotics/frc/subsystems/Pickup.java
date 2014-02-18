package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The pickup for the robot.
 * @author Saints Robotics
 */
public class Pickup extends Subsystem {
    private final Relay relay;
    private final DigitalInput digitalInput;
    
    public Pickup() {
        relay = new Relay(RobotMap.PICKUP_RELAY, RobotMap.PICKUP_RELAY_DIRECTION);
        digitalInput = new DigitalInput(RobotMap.PICKUP_DIGITAL_INPUT);
    }
    
    public void pickup() {
        relay.set(Relay.Value.kForward);
        
        updateDashboard();
    }
    
    public void reverse() {
        relay.set(Relay.Value.kReverse);
        
        updateDashboard();
    }
    
    public void stop() {
        relay.set(Relay.Value.kOff);
        
        updateDashboard();
    }
    
    public boolean isHalfLoaded() {
        return !digitalInput.get();
    }
    
    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        SmartDashboard.putString("Pickup", relay.get().toString());
    }
}
