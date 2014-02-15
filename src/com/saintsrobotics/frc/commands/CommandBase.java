package com.saintsrobotics.frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.saintsrobotics.frc.OI;
import com.saintsrobotics.frc.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Saints Robotics
 */
public abstract class CommandBase extends Command {
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static final DriveTrain driveTrain = new DriveTrain();
    public static final Pickup pickup = new Pickup();
    public static final Shooter shooter = new Shooter();
    public static final GearShifter gearShifter = new GearShifter();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
