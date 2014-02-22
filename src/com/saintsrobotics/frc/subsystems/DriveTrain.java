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
    private static final double SLOW_MODE_FACTOR = 0.2;
    
    private final RobotDrive drive;
    private boolean slowMode;
    private boolean reversed;
    
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
        // Adjust values
        moveValue = adjustValue(moveValue);
        rotateValue = adjustValue(rotateValue);
        
        // Drive!
        drive.arcadeDrive(moveValue, rotateValue, RobotMap.SQUARED_INPUTS);
        
        SmartDashboard.putNumber("Arcade move", moveValue);
        SmartDashboard.putNumber("Arcade rotate", rotateValue);
    }
    
    /**
     * Allow the robot to be driven using tank drive.
     * @param leftValue the speed for the left
     * @param rightValue the speed for the right
     */
    public void tankDrive(double leftValue, double rightValue) {
        // Adjust values
        leftValue = adjustValue(leftValue);
        rightValue = adjustValue(rightValue);
        
        // Drive!
        drive.tankDrive(leftValue, rightValue, RobotMap.SQUARED_INPUTS);
        
        SmartDashboard.putNumber("Tank left", leftValue);
        SmartDashboard.putNumber("Tank right", rightValue);
    }
    
    /**
     * Stop the robot.
     */
    public void stop() {
        drive.stopMotor();
    }
    
    public boolean isSlowMode() {
        return slowMode;
    }
    
    public void setSlowMode(boolean slowMode) {
        this.slowMode = slowMode;
    }
    
    public boolean isReversed() {
        return reversed;
    }
    
    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }
    
    private double adjustValue(double value) {
        // Reverse
        if (reversed) {
            value = -value;
        }
        
        // Slow mode
        if (slowMode) {
            value *= SLOW_MODE_FACTOR;
        }
        
        return value;
    }
    
    protected void initDefaultCommand() {}
}
