package com.example.smart.home.sensors.motion;

/**
 * Service interface for a motion sensor.
 * This interface defines methods for interacting with a motion sensor,
 * such as detecting if motion has occurred.
 */
public interface MotionSensorService {

    /**
     * Checks if motion has been detected by the sensor.
     * 
     * @return true if motion is detected, false otherwise.
     */
    boolean isMotionDetected();
}
