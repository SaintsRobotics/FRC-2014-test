package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
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
    private boolean isHalfLoaded;
    
    public Pickup() {
        relay = new Relay(Constants.PICKUP_RELAY, Constants.PICKUP_RELAY_DIRECTION);
        digitalInput = new DigitalInput(Constants.PICKUP_DIGITAL_INPUT);
    }
    
    public void pickup() {
        if (isAtHalfLoadedState() && !isHalfLoaded) {
            isHalfLoaded = true;
        } else if (!isAtHalfLoadedState() && isHalfLoaded) {
            isHalfLoaded = false;
        }
        
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
    
    public boolean isAtHalfLoadedState() {
        return !digitalInput.get();
    }
    
    public boolean isHalfLoaded() {
        return isHalfLoaded;
    }
    
    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        SmartDashboard.putString("Pickup", relay.get().toString());
    }
}
