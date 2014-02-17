package com.saintsrobotics.frc.commands.autonomous;

import com.saintsrobotics.frc.commands.CommandBase;

/**
 * Shoot into the high goal, during autonomous.
 * @author Saints Robotics
 */
public class ShootHighGoal extends CommandBase {
    private boolean isFinished;
    
    public ShootHighGoal() {
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
        shooter.shoot();
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
