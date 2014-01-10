package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Saints Robotics
 */
public class DriveTrain extends Subsystem {
    private final RobotDrive drive;
    
    public DriveTrain() {
        SpeedController leftMotor = new Victor(RobotMap.LEFT_MOTOR);
        SpeedController rightMotor = new Victor(RobotMap.RIGHT_MOTOR);
        drive = new RobotDrive(leftMotor, rightMotor);
    }
    
    public void arcadeDrive(double moveValue, double rotateValue) {
        drive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
    }
    
    public void stop() {
        drive.stopMotor();
    }
    
    public void setSafetyEnabled(boolean enabled) {
        drive.setSafetyEnabled(enabled);
    }
    
    protected void initDefaultCommand() {}
}
