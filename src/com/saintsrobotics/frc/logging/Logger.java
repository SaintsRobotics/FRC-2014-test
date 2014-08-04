package com.saintsrobotics.frc.logging;

/**
 * A basic logger.
 * @author Saints Robotics
 */
public abstract class Logger {
    public Logger() {}
    
    /**
     * Log an exception.
     * @param exception the exception logged
     */
    public void log(Exception exception) {
        String message = exception.toString();
        log(message);
    }
    
    /**
     * Log a message.
     * @param message the message logged
     */
    public abstract void log(String message);
}
