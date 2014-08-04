package com.saintsrobotics.frc.logging;

/**
 * Allow static logging.
 * @author Saints Robotics
 */
public final class Log {
    /**
     * The loggers used. Swap this out if desired.
     */
    private static final Logger[] loggers = { new ConsoleLogger() };
    
    /**
     * Disallow instantiation.
     */
    private Log() {}
    
    /**
     * Log a message.
     * @param message the message logged
     */
    public static void log(String message) {
        for (int index = 0; index < loggers.length; index++) {
            loggers[index].log(message);
        }
    }
    
    /**
     * Log an exception.
     * @param exception the exception logged
     */
    public static void log(Exception exception) {
        for (int index = 0; index < loggers.length; index++) {
            loggers[index].log(exception);
        }
    }
}
