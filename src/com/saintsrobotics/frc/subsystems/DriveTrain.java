package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive train for the robot.
 * @author Saints Robotics
 */
public class DriveTrain extends Subsystem {
    private final RobotDrive drive;
    
    public DriveTrain() {
        SpeedController leftMotor = new Victor(RobotMap.LEFT_MOTOR);
        SpeedController rightMotor = new Victor(RobotMap.RIGHT_MOTOR);
        drive = new RobotDrive(leftMotor, rightMotor);
    }
    
    /**
     * Allow the robot to be driven using arcade drive.
     * @param moveValue the move speed
     * @param rotateValue the rotation speed
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
        drive.arcadeDrive(moveValue, rotateValue);
    }
    
    /**
     * Allow the robot to be driven using tank drive.
     * @param leftValue the speed for the left
     * @param rightValue the speed for the right
     */
    public void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
    }
    
    /**
     * Stop the robot.
     */
    public void stop() {
        drive.stopMotor();
    }
    
    public void setSafetyEnabled(boolean enabled) {
        drive.setSafetyEnabled(enabled);
    }
    
    protected void initDefaultCommand() {}
}
