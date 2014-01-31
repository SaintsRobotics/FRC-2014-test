package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The pickup for the robot.
 * @author Saints Robotics
 */
public class Pickup extends Subsystem {
    private final SpeedController motor;
    
    public Pickup() {
        motor = new Victor(RobotMap.PICKUP_MOTOR);
    }
    
    public void run(double speed) {
        motor.set(speed);
    }
    
    protected void initDefaultCommand() {}
}
