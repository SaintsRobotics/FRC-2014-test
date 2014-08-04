package com.saintsrobotics.frc.logging;

import com.saintsrobotics.frc.Constants;

/**
 * Allow static logging.
 * @author Saints Robotics
 */
public final class Log {
    /**
     * Disallow instantiation.
     */
    private Log() {}
    
    /**
     * Log a message.
     * @param message the message logged
     */
    public static void log(String message) {
        for (int index = 0; index < Constants.LOGGERS.length; index++) {
            Constants.LOGGERS[index].log(message);
        }
    }
    
    /**
     * Log an exception.
     * @param exception the exception logged
     */
    public static void log(Exception exception) {
        for (int index = 0; index < Constants.LOGGERS.length; index++) {
            Constants.LOGGERS[index].log(exception);
        }
    }
}
