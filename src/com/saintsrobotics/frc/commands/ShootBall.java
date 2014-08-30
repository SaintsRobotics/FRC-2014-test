package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Shoot a ball with the shooter, but do not reset the position of the shooter.
 * @author Saints Robotics
 */
public class ShootBall extends CommandBase {
    public ShootBall() {
        requires(shooter);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        if (shooter.isReadyToShoot()) {
            shooter.start();
            Log.log("Shooting...");
        } else {
            Log.log("Not ready to shoot!");
        }
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {}

    /**
     * Returns whether this command is finished.
     * @return whether this command is finished
     */
    protected boolean isFinished() {
        return !shooter.isReadyToShoot();
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
