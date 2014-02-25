package com.saintsrobotics.frc.subsystems;

import com.saintsrobotics.frc.Constants;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The gear shifter for the robot.
 * @author Saints Robotics
 */
public class GearShifter extends Subsystem {
    private static final double HIGH = 1;
    private static final double LOW = 0;
    
    private final Servo servo1;
    private final Servo servo2;
    
    public GearShifter() {
        servo1 = new Servo(Constants.GEAR_SHIFTER_SERVO_1_PORT);
        servo2 = new Servo(Constants.GEAR_SHIFTER_SERVO_2_PORT);
    }
    
    /**
     * Shift the gear up to high gear.
     */
    public void shiftToHighGear() {
        servo1.set(HIGH);
        servo2.set(LOW);
        
        updateDashboard();
    }
    
    /**
     * Shift the gear down to low gear.
     */
    public void shiftToLowGear() {
        servo1.set(LOW);
        servo2.set(HIGH);
        
        updateDashboard();
    }

    protected void initDefaultCommand() {}
    
    private boolean inHighGear() {
        return servo1.get() == HIGH && servo2.get() == LOW;
    }
    
    private void updateDashboard() {
        SmartDashboard.putString("Gear shifter in high gear", inHighGear() ? "True" : "False");
    }
}
