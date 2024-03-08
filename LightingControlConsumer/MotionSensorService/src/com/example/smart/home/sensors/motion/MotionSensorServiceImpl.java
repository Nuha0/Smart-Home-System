package com.example.smart.home.sensors.motion;

import java.util.Random;

/**
 * Implementation of the MotionSensorService interface.
 * This class simulates motion detection with random outcomes.
 */
public class MotionSensorServiceImpl implements MotionSensorService {
    
    private Random random = new Random();

    /**
     * Simulates motion detection.
     * Randomly returns true or false to simulate the detection of motion.
     * 
     * @return true if motion is detected (simulated), false otherwise.
     */
    @Override
    public boolean isMotionDetected() {
        // Randomly simulate motion detection
        return random.nextBoolean();
    }
}
