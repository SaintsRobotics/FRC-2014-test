package com.saintsrobotics.frc.commands.autonomous;

import com.saintsrobotics.frc.commands.ResetShootBall;
import com.saintsrobotics.frc.commands.ShootBall;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The basic autonomous command.
 * @author Saints Robotics
 */
public class BasicAutonomous extends CommandGroup {
    public BasicAutonomous() {
        // Shoot the preloaded ball!
        addSequential(new ShootBall());
        
        // Reset the shooter as we move forward
        addParallel(new MoveIntoZone());
        addParallel(new ResetShootBall());
    }
}
