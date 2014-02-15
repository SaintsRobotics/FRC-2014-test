package com.saintsrobotics.frc.commands;

/**
 * Pick up a ball with the pickup mechanism.
 * @author Saints Robotics
 */
public class PickupBall extends CommandBase {
    private boolean isFinished;
    
    public PickupBall() {
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
        pickup.pickup();
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
