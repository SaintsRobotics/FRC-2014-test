package com.saintsrobotics.frc.commands.autonomous;

import com.saintsrobotics.frc.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 * Move into the alliance's zone.
 * @author Saints Robotics
 */
public class MoveIntoZone extends CommandBase {
    private static final int FULL_SPEED_MOVE = 1;
    private static final int FULL_SPEED_ROTATE = 0;
    
    private final double driveSeconds;
    private boolean isFinished;
    private double startTime;
    
    public MoveIntoZone(double driveSeconds) {
        requires(driveTrain);
        
        this.driveSeconds = driveSeconds;
    }
    
    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        double moveValue = FULL_SPEED_MOVE;
        double rotateValue = FULL_SPEED_ROTATE;
        
        driveTrain.arcadeDrive(moveValue, rotateValue);
        
        // Record starting time of drive
        startTime = Timer.getFPGATimestamp();
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        double currentTime = Timer.getFPGATimestamp();
        
        // Stop if more than driveSeconds have elapsed
        if (currentTime - startTime >= driveSeconds) {
            driveTrain.stop();
            isFinished = true;
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
