package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
import com.saintsrobotics.frc.commands.ArcadeDrive;
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
        SpeedController leftMotor1 = new Talon(Constants.DRIVE_LEFT_MOTOR_1_PORT);
        SpeedController leftMotor2 = new Talon(Constants.DRIVE_LEFT_MOTOR_2_PORT);
        SpeedController rightMotor1 = new Talon(Constants.DRIVE_RIGHT_MOTOR_1_PORT);
        SpeedController rightMotor2 = new Talon(Constants.DRIVE_RIGHT_MOTOR_2_PORT);
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
        // Drive!
        drive.arcadeDrive(moveValue, rotateValue, Constants.DRIVE_SQUARED_INPUTS);
        
        SmartDashboard.putNumber("Arcade move", moveValue);
        SmartDashboard.putNumber("Arcade rotate", rotateValue);
    }
    
    /**
     * Allow the robot to be driven using tank drive.
     * @param leftValue the speed for the left
     * @param rightValue the speed for the right
     */
    public void tankDrive(double leftValue, double rightValue) {
        // Drive!
        drive.tankDrive(leftValue, rightValue, Constants.DRIVE_SQUARED_INPUTS);
        
        SmartDashboard.putNumber("Tank left", leftValue);
        SmartDashboard.putNumber("Tank right", rightValue);
    }
    
    /**
     * Stop the robot.
     */
    public void stop() {
        drive.stopMotor();
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}
