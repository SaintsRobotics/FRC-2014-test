package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The shooter for the robot.
 * @author Saints Robotics
 */
public class Shooter extends Subsystem {
    private final Relay relay;
    
    public Shooter() {
        relay = new Relay(RobotMap.SHOOTER_RELAY, RobotMap.SHOOTER_RELAY_DIRECTION);
    }
    
    public void shoot() {
        relay.set(Relay.Value.kForward);
    }
    
    public void stop() {
        relay.set(Relay.Value.kReverse);
    }

    protected void initDefaultCommand() {}
}
