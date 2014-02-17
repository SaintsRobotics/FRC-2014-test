package com.saintsrobotics.frc.logging;

/**
 * A logger that logs to the console.
 * @author Saints Robotics
 */
public class ConsoleLogger extends LoggerDecorator {
    public ConsoleLogger() {
        super();
    }
    
    public ConsoleLogger(Logger logger) {
        super(logger);
    }
    
    public void log(String message) {
        super.log(message);
        
        System.out.println(message);
    }
}
