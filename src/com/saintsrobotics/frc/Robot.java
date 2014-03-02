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
import com.saintsrobotics.frc.commands.autonomous.BasicAutonomous;
import com.saintsrobotics.frc.logging.Log;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
    }

    /**
     * This function is called at the beginning of autonomous.
     */
    public void autonomousInit() {
        Log.log("Autonomous has begun!");
        
        // Cancel the currently-running autonomous command
        cancelAutonomous();
        
        // Run the current autonomous command
        autonomousCommand = new BasicAutonomous();
        autonomousCommand.start();
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
        Log.log("Teleop has begun!");
        
        // Cancel the currently-running autonomous command
        cancelAutonomous();
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
        Log.log("Test mode has begun!");
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
        Log.log("The robot has been disabled.");
        
        // Cancel the currently-running autonomous command
        cancelAutonomous();
    }

    /**
     * This function is called periodically during disabled mode.
     */
    public void disabledPeriodic() {}
    
    /**
     * Cancel the currently-running autonomous command, if applicable.
     */
    private void cancelAutonomous() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
            autonomousCommand = null;
        }
    }
}
