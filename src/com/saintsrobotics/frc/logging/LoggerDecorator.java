package com.saintsrobotics.frc.logging;

/**
 * Apply the decorator pattern for the logger.
 * @author Saints Robotics
 */
public class LoggerDecorator extends Logger {
    private final Logger logger;
    
    public LoggerDecorator() {
        this(new NoLogger());
    }
    
    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }
    
    public void log(String message) {
        logger.log(message);
    }
}
