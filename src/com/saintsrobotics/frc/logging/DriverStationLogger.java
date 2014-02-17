package com.saintsrobotics.frc.logging;

import com.saintsrobotics.frc.DriverStationComm;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * A logger that logs to the driver station.
 * @author Saints Robotics
 */
public class DriverStationLogger extends LoggerDecorator {
    private static final DriverStationLCD.Line LINE =
            DriverStationLCD.Line.kUser6;
    
    public DriverStationLogger() {
        super();
    }
    
    public DriverStationLogger(Logger logger) {
        super(logger);
    }
    
    public void log(String message) {
        super.log(message);
        
        DriverStationComm.printMessage(message, LINE);
    }
}
