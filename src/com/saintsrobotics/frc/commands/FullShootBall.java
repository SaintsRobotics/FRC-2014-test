package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Completely shoot the ball.
 * @author Saints Robotics
 */
public class FullShootBall extends CommandGroup {
    public FullShootBall() {
        addSequential(new ShootBall());
        addSequential(new ResetShootBall());
    }
}
