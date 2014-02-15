package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The pickup for the robot.
 * @author Saints Robotics
 */
public class Pickup extends Subsystem {
    private final Relay relay;
    
    public Pickup() {
        relay = new Relay(RobotMap.PICKUP_RELAY, RobotMap.PICKUP_RELAY_DIRECTION);
    }
    
    public void pickup() {
        relay.set(Relay.Value.kForward);
    }
    
    public void reverse() {
        relay.set(Relay.Value.kReverse);
    }
    
    public void stop() {
        relay.set(Relay.Value.kOff);
    }
    
    protected void initDefaultCommand() {}
}
