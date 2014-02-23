package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Shoot a ball with the shooter, but do not reset the position of the shooter.
 * Useful for resetting the shooter to the un-tensioned position.
 * @author Saints Robotics
 */
public class ShootBall extends CommandBase {
    public ShootBall() {
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
        if (shooter.isReadyToShoot()) {
            shooter.start();
            Log.log("Robot is shooting!");
        } else {
            Log.log("Robot is not ready to shoot!");
        }
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
