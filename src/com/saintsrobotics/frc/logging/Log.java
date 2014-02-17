package com.saintsrobotics.frc.logging;

/**
 * Allow static logging.
 * @author Saints Robotics
 */
public class Log {
    /**
     * The logger used. Swap this out if desired.
     */
    private static final Logger logger = new DriverStationLogger(new ConsoleLogger());
    
    /**
     * Disallow instantiation.
     */
    private Log() {}
    
    /**
     * Log a message.
     * @param message the message logged
     */
    public static void log(String message) {
        logger.log(message);
    }
    
    /**
     * Log an exception.
     * @param exception the exception logged
     */
    public static void log(Exception exception) {
        logger.log(exception);
    }
}
