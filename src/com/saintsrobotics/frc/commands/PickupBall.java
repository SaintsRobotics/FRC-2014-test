package com.saintsrobotics.frc.commands;

/**
 * Pick up a ball with the pickup mechanism.
 * @author Saints Robotics
 */
public class PickupBall extends CommandBase {
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
        double value = oi.getPickupJoy();
        
        pickup.run(value);
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
        pickup.run(0);
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        end();
    }
}
