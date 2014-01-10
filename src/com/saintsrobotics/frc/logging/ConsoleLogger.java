package com.saintsrobotics.frc.logging;

/**
 * A logger that logs to the console.
 * @author Saints Robotics
 */
public class ConsoleLogger extends Logger
{
    public void log(String message)
    {
        System.out.println(message);
    }
}
