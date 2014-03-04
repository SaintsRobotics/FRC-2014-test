package com.saintsrobotics.frc.utilities;

/**
 * An implementation of a moving/running average.
 * @author Saints Robotics
 */
public class MovingAverage {
    private final double[] samples;
    private final int size;
    
    private double total;
    private int currentIndex;
    
    public MovingAverage(int size) {
        this.size = size;
        samples = new double[size];
    }
    
    public double getAverage() {
        return total / size;
    }
    
    public void add(double sample) {
        // Remove current sample
        total -= samples[currentIndex];
        
        // Add current sample
        samples[currentIndex] = sample;
        total += sample;
        
        // Increment index
        currentIndex++;
        
        if (currentIndex >= size) {
            currentIndex = 0;
        }
    }
}
