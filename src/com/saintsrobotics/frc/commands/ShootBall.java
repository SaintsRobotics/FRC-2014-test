package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;

/**
 * Shoot a ball with the shooter.
 * @author Saints Robotics
 */
public class ShootBall extends CommandBase {
    private boolean isFinished;
    
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
        } else {
            Log.log("Robot is not ready to shoot!");
        }
        
        isFinished = true;
    }

    /**
     * Returns whether this command is finished.
     * @return whether this command is finished
     */
    protected boolean isFinished() {
        return isFinished;
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
