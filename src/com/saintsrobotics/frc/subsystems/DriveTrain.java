package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The drive train for the robot.
 * @author Saints Robotics
 */
public class DriveTrain extends Subsystem {
    private static final double SAFETY_EXPIRATION = 0.5;
    private final RobotDrive drive;
    
    public DriveTrain() {
        SpeedController leftMotor1 = new Talon(RobotMap.LEFT_MOTOR_1);
        SpeedController leftMotor2 = new Talon(RobotMap.LEFT_MOTOR_2);
        SpeedController rightMotor1 = new Talon(RobotMap.RIGHT_MOTOR_1);
        SpeedController rightMotor2 = new Talon(RobotMap.RIGHT_MOTOR_2);
        drive = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
        
        // Enable safety mode
        drive.setSafetyEnabled(true);
        drive.setExpiration(SAFETY_EXPIRATION);
    }
    
    /**
     * Allow the robot to be driven using arcade drive.
     * @param moveValue the move speed
     * @param rotateValue the rotation speed
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
        drive.arcadeDrive(moveValue, rotateValue);
        
        SmartDashboard.putNumber("Arcade move", moveValue);
        SmartDashboard.putNumber("Arcade rotate", rotateValue);
    }
    
    /**
     * Allow the robot to be driven using tank drive.
     * @param leftValue the speed for the left
     * @param rightValue the speed for the right
     */
    public void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
        
        SmartDashboard.putNumber("Tank left", leftValue);
        SmartDashboard.putNumber("Tank right", rightValue);
    }
    
    /**
     * Stop the robot.
     */
    public void stop() {
        drive.stopMotor();
    }
    
    protected void initDefaultCommand() {}
}
