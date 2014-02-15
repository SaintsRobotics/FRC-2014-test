package com.saintsrobotics.frc.utilities;

/**
 * A type-safe enum for the Xbox axes.
 * @author Saints Robotics
 */
public class XboxAxis {
    public final int value;

    protected static final int LEFT_THUMB_X_VAL = 3;
    protected static final int LEFT_THUMB_Y_VAL = 2;
    protected static final int RIGHT_THUMB_X_VAL = 4;
    protected static final int RIGHT_THUMB_Y_VAL = 5;

    public static final XboxAxis LEFT_THUMB_X = new XboxAxis(LEFT_THUMB_X_VAL);
    public static final XboxAxis LEFT_THUMB_Y = new XboxAxis(LEFT_THUMB_Y_VAL);
    public static final XboxAxis RIGHT_THUMB_X = new XboxAxis(RIGHT_THUMB_X_VAL);
    public static final XboxAxis RIGHT_THUMB_Y = new XboxAxis(RIGHT_THUMB_Y_VAL);

    private XboxAxis(int value) {
        this.value = value;
    }
}
