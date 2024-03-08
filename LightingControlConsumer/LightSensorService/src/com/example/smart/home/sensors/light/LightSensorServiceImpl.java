package com.example.smart.home.sensors.light;

import java.util.Random;

/**
 * Implementation of the LightSensorService interface.
 * This class simulates light level readings with random values.
 */
public class LightSensorServiceImpl implements LightSensorService {
    
    private Random random = new Random();

    /**
     * Simulates getting the current light level from a sensor.
     * Generates a random light level between 0 (complete darkness) and 1000 (bright sunlight).
     * 
     * @return the current simulated light level as an integer.
     */
    @Override
    public int getLightLevel() {
        // Define the range for light levels
        int minLightLevel = 0; // Minimum light level, representing complete darkness
        int maxLightLevel = 1000; // Maximum light level, representing bright sunlight

        // Generate a random light level within the range
        return random.nextInt(maxLightLevel - minLightLevel + 1) + minLightLevel;
    }
}
