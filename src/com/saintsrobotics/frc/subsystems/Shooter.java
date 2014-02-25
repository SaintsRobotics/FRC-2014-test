package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The shooter for the robot.
 * @author Saints Robotics
 */
public class Shooter extends Subsystem {
    private final Relay relay;
    private final DigitalInput digitalInput;
    private boolean isShooting;
    
    public Shooter() {
        relay = new Relay(Constants.SHOOTER_RELAY_PORT, 
                Constants.SHOOTER_RELAY_DIRECTION);
        digitalInput = new DigitalInput(Constants.SHOOTER_DIGITAL_INPUT_PORT);
    }
    
    public void start() {
        if (isReadyToShoot() && !isShooting) {
            isShooting = true;
        } else if (!isReadyToShoot() && isShooting) {
            isShooting = false;
        }
        
        relay.set(Relay.Value.kOn);
        
        updateDashboard();
    }
    
    public void stop() {
        isShooting = false;
        
        relay.set(Relay.Value.kOff);
        
        updateDashboard();
    }
    
    public boolean isShooting() {
        return isShooting;
    }
    
    public boolean isReadyToShoot() {
        return !digitalInput.get();
    }

    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        SmartDashboard.putString("Shooter", relay.get().toString());
    }
}
