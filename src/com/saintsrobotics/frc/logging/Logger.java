package com.saintsrobotics.frc.logging;

/**
 * A basic logger.
 * @author Saints Robotics
 */
public abstract class Logger {
    private static final Logger logger = new ConsoleLogger();
    
    public static Logger getLogger() {
        return logger;
    }
    
    public void log(Exception exception) {
        String message = exception.toString();
        log(message);
    }
    
    public abstract void log(String message);
}
