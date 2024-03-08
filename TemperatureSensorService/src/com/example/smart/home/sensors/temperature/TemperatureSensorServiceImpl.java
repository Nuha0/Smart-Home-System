package com.example.smart.home.sensors.temperature;

import java.util.Random;

/**
 * Implementation of the TemperatureSensorService interface.
 * This class simulates temperature readings with random values.
 */
public class TemperatureSensorServiceImpl implements TemperatureSensorService {
    
    private Random random = new Random();

    /**
     * Simulates getting the current temperature from a sensor.
     * Generates a random temperature between 18.0°C (64.4°F) and 24.0°C (75.2°F).
     * 
     * @return the current simulated temperature as a double.
     */
    @Override
    public double getCurrentTemperature() {
        // Define the range for temperature values
        double minTemperature = 18.0; // Minimum temperature in degrees Celsius
        double maxTemperature = 24.0; // Maximum temperature in degrees Celsius

        // Generate a random temperature within the range
        return minTemperature + (maxTemperature - minTemperature) * random.nextDouble();
    }
}
