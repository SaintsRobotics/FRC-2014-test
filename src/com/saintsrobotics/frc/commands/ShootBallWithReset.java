package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Fully shoot a ball, including resetting the shooter arm.
 * @author Saints Robotics
 */
public class ShootBallWithReset extends CommandGroup {
    public ShootBallWithReset() {
        addSequential(new ShootBall());
        addSequential(new ResetShootBall());
    }
}
