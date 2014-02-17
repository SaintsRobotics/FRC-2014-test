package com.saintsrobotics.frc;

import com.saintsrobotics.frc.logging.Log;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Communicate with the driver station.
 * @author Saints Robotics
 */
public class DriverStationComm {
    private static final int FIRST_COLUMN = 1;
    private static final DriverStation driverStation =
            DriverStation.getInstance();
    private static final DriverStationEnhancedIO driverStationIO =
            driverStation.getEnhancedIO();
    private static final DriverStationLCD driverStationLCD =
            DriverStationLCD.getInstance();
    
    /**
     * Disallow instantiation.
     */
    private DriverStationComm() {}
    
    /**
     * Print a message to the "User messages" box in the driver station.
     * @param message the message to be printed
     * @param line the line number
     */
    public static void printMessage(String message, DriverStationLCD.Line line) {
        printMessage(message, line, FIRST_COLUMN);
    }
    
    /**
     * Print a message to the "User messages" box in the driver station.
     * @param message the message to be printed
     * @param line the line number
     * @param startingColumn the column to start printing to
     */
    public static void printMessage(String message, DriverStationLCD.Line line,
            int startingColumn) {
        if (message.length() > DriverStationLCD.kLineLength) {
            message = message.substring(0, DriverStationLCD.kLineLength);
        }
        
        driverStationLCD.println(line, startingColumn, message);
        driverStationLCD.updateLCD();
    }
    
    /**
     * Set the state of the LED lights.
     * @param channel the LED channel
     * @param on true to turn the LED on
     */
    public static void setLED(int channel, boolean on) {
        try {
            driverStationIO.setLED(channel, on);
        } catch (EnhancedIOException exception) {
            Log.log(exception);
        }
    }
}
