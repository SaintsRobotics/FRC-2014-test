package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Shoot a ball without resetting its position.
 * @author Saints Robotics
 */
public class ShootBallWithoutReset extends CommandGroup {
    public ShootBallWithoutReset() {
        addSequential(new ShootBall());
        addSequential(new StopShootBall());
    }
}
