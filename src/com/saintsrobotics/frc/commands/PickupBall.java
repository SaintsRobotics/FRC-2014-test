package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Pick up a ball with the pickup mechanism. There are two initial states for
 * the ball:
 * 
 * 1. The ball is not in the robot. The pickup should run until the limit switch
 *    returns false.
 * 2. The ball is already in the robot, at the half loaded point. The pickup
 *    should run continuously.
 * 
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
    protected void initialize() {
        if (pickup.isHalfLoaded()) {
            isFinished = true;
        }
        
        pickup.pickup();
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        if (pickup.isHalfLoaded()) {
            isFinished = true;
            
            Command stopPickupBallCommand = new StopPickupBall();
            stopPickupBallCommand.start();
        }
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
