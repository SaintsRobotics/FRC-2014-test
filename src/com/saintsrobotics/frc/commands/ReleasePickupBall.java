package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Release a ball in the pickup mechanism.
 * @author Saints Robotics
 */
public class ReleasePickupBall extends CommandBase {
    public ReleasePickupBall() {
        requires(pickup);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {}

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        pickup.reverse();
        Log.log("Releasing balls...");
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
