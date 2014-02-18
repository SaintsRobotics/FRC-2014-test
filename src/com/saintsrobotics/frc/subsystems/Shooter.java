package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
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
    
    public Shooter() {
        relay = new Relay(RobotMap.SHOOTER_RELAY, RobotMap.SHOOTER_RELAY_DIRECTION);
        digitalInput = new DigitalInput(RobotMap.SHOOTER_DIGITAL_INPUT);
    }
    
    public void start() {
        relay.set(Relay.Value.kOn);
        
        updateDashboard();
    }
    
    public void stop() {
        relay.set(Relay.Value.kOff);
        
        updateDashboard();
    }
    
    public boolean isReadyToShoot() {
        return !digitalInput.get();
    }

    protected void initDefaultCommand() {}
    
    private void updateDashboard() {
        SmartDashboard.putString("Shooter", relay.get().toString());
    }
}
