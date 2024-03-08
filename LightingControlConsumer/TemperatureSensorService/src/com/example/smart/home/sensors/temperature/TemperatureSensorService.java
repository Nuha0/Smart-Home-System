package com.example.smart.home.sensors.temperature;

/**
 * Service interface for a temperature sensor.
 * This interface defines the methods that can be called on a temperature sensor service.
 */
public interface TemperatureSensorService {

    /**
     * Gets the current temperature measured by the sensor.
     * @return the current temperature as a double.
     */
    double getCurrentTemperature();
}
