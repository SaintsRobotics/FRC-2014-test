package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Stop shooting the ball.
 * @author Saints Robotics
 */
public class StopShootBall extends CommandBase {
    public StopShootBall() {
        requires(shooter);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {}

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        shooter.stop();
        Log.log("Stopped shooting.");
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
