package com.saintsrobotics.frc.commands.autonomous;

import com.saintsrobotics.frc.commands.ResetShootBall;
import com.saintsrobotics.frc.commands.ShootBall;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The basic autonomous command.
 * @author Saints Robotics
 */
public class BasicAutonomous extends CommandGroup {
    private static final double DRIVE_SECONDS = 1.0;
    
    public BasicAutonomous() {
        // Move forward to lower pickup
        addSequential(new MoveIntoZone(DRIVE_SECONDS));
        
        // Shoot the preloaded ball!
        addSequential(new ShootBall());
        
        // Reset the shooter
        addSequential(new ResetShootBall());
    }
}
