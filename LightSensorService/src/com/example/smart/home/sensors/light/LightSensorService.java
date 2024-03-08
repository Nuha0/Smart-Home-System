package com.example.smart.home.sensors.light;

/**
 * Service interface for a light sensor.
 * This interface defines methods for interacting with a light sensor, such as retrieving the current light level.
 */
public interface LightSensorService {

    /**
     * Gets the current light level detected by the sensor.
     * The light level could be measured in lux, a unit of illuminance.
     *
     * @return the current light level as an integer.
     */
    int getLightLevel();
}
