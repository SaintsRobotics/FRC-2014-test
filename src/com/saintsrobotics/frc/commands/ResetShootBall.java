package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Reset the shooter so that it is ready to shoot.
 * @author Saints Robotics
 */
public class ResetShootBall extends CommandBase {
    public ResetShootBall() {
        requires(shooter);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        if (!shooter.isReadyToShoot()) {
            shooter.start();
            Log.log("Resetting shooter...");
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
        return shooter.isReadyToShoot();
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        shooter.stop();
        Log.log("Shooter has reset.");
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        end();
    }
}
