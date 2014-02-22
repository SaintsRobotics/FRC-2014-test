package com.saintsrobotics.frc.commands;

/**
 * Toggle reversed drive for the robot.
 * @author Saints Robotics
 */
public class ToggleDriveReversed extends CommandBase {
    public ToggleDriveReversed() {}
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {}

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        boolean currentReversed = oi.isDriveReversed();
        oi.setDriveReversed(!currentReversed);
    }

    /**
     * Returns whether this command is finished.
     * @return whether this command is finished
     */
    protected boolean isFinished() {
        return true;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {}

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        end();
    }
}
