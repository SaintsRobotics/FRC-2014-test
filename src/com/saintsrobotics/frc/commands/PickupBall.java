package com.saintsrobotics.frc.commands;

import com.saintsrobotics.frc.logging.Log;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Pick up a ball with the pickup mechanism. This should wait a certain time
 * before checking the limit switch to see if it is picked up.
 * @author Saints Robotics
 */
public class PickupBall extends CommandBase {
    private static final double LIMIT_SWITCH_CHECK_DELAY = 0.75;
    private boolean isFinished;
    
    public PickupBall() {
        requires(pickup);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        pickup.pickup();
        Log.log("Picking up balls...");
        //Timer.delay(LIMIT_SWITCH_CHECK_DELAY);
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        /*if (pickup.isHalfLoaded()) {
            isFinished = true;
            Log.log("Reached the pickup limit switch.");
            
            Command stopPickupBallCommand = new StopPickupBall();
            stopPickupBallCommand.start();
        }*/
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
