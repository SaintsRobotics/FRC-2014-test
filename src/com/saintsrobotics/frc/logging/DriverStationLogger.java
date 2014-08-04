package com.saintsrobotics.frc.logging;

import com.saintsrobotics.frc.DriverStationComm;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * A logger that logs to the driver station.
 * @author Saints Robotics
 */
public class DriverStationLogger extends Logger {
    private static final DriverStationLCD.Line LINE =
            DriverStationLCD.Line.kUser6;
    
    public DriverStationLogger() {}
    
    /**
     * Log a message.
     * @param message the message logged
     */
    public void log(String message) {
        DriverStationComm.printMessage(message, LINE);
    }
}
