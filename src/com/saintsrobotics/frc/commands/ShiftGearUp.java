package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.Relay;

/**
 * Shift the gear up or down, depending on its current state.
 * @author Saints Robotics
 */
public class ShiftGearUp extends CommandBase {
    private boolean isFinished;
    
    public ShiftGearUp() {
        requires(gearShifter);
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {}

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        if (gearShifter.isHigherGear()) {
            gearShifter.shiftDown();
        } else {
            gearShifter.shiftUp();
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
