package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The gear shifter for the robot.
 * @author Saints Robotics
 */
public class GearShifter extends Subsystem {
    private final Relay relay;
    
    public GearShifter() {
        relay = new Relay(RobotMap.GEAR_SHIFTER_RELAY,
                RobotMap.GEAR_SHIFTER_RELAY_DIRECTION);
    }
    
    /**
     * Returns whether the robot is in the higher gear.
     * @return whether the robot is in the higher gear
     */
    public boolean isHigherGear() {
        Relay.Value relayState = relay.get();
        
        return relayState.equals(Relay.Value.kForward);
    }
    
    /**
     * Shift the gear up.
     */
    public void shiftUp() {
        relay.set(Relay.Value.kForward);
    }
    
    /**
     * Shift the gear down.
     */
    public void shiftDown() {
        relay.set(Relay.Value.kReverse);
    }

    protected void initDefaultCommand() {}
}
