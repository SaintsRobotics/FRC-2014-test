package com.saintsrobotics.frc.commands;

/**
 * Arcade drive for the robot.
 * @author Saints Robotics
 */
public class ArcadeDrive extends CommandBase {
    public ArcadeDrive() {
        requires(driveTrain);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {}

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        double moveValue = oi.getArcadeMoveJoy();
        double rotateValue = oi.getArcadeRotateJoy();
        
        driveTrain.arcadeDrive(moveValue, rotateValue);
    }

    /**
     * Returns whether this command is finished.
     * @return whether this command is finished
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        driveTrain.stop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        end();
    }
}
