/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.saintsrobotics.frc.commands.*;
import com.saintsrobotics.frc.logging.Logger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private final Logger logger = Logger.getLogger();
    private Command driveWithJoysticksCommand;
    private Command pickupBallCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize commands
        driveWithJoysticksCommand = new DriveWithJoysticks();
        pickupBallCommand = new PickupBall();

        // Initialize all subsystems
        CommandBase.init();
    }

    /**
     * This function is called at the beginning of autonomous.
     */
    public void autonomousInit() {
        logger.log("Autonomous has begun!");
    }

    /**
     * This function is called periodically during autonomous.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called at the beginning of operator control.
     */
    public void teleopInit() {
        logger.log("Teleop has begun!");
        driveWithJoysticksCommand.start();
        pickupBallCommand.start();
    }

    /**
     * This function is called periodically during operator control.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called at the beginning of test mode.
     */
    public void testInit() {
        logger.log("Test mode has begun!");
    }
    
    /**
     * This function is called periodically during test mode.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * This function is called at the beginning of disabled mode.
     */
    public void disabledInit() {
        logger.log("The robot has been disabled :(");
    }

    /**
     * This function is called periodically during disabled mode.
     */
    public void disabledPeriodic() {}
}
