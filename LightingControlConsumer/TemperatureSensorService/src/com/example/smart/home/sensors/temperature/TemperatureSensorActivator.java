package com.example.smart.home.sensors.temperature;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Activator class for the Temperature Sensor bundle.
 * This class manages the lifecycle of the bundle and registers the TemperatureSensorService
 * with the OSGi service registry when the bundle is started.
 */
public class TemperatureSensorActivator implements BundleActivator {

    // Service registration object to manage the registration of the TemperatureSensorService
    private ServiceRegistration<?> registration;

    /**
     * Called when the OSGi framework starts the bundle.
     * This method registers the TemperatureSensorService with the OSGi service registry.
     *
     * @param context the execution context of the bundle being started.
     */
    @Override
    public void start(BundleContext context) {
        // Create an instance of the TemperatureSensorServiceImpl
        TemperatureSensorService service = new TemperatureSensorServiceImpl();
        
        // Register the service with the OSGi framework
        registration = context.registerService(TemperatureSensorService.class.getName(), service, null);
        System.out.println("Temperature Sensor Service registered successfully.");
    }

    /**
     * Called when the OSGi framework stops the bundle.
     * This method unregisters the TemperatureSensorService from the OSGi service registry.
     *
     * @param context the execution context of the bundle being stopped.
     */
    @Override
    public void stop(BundleContext context) {
        // Unregister the service
        registration.unregister();
        System.out.println("Temperature Sensor Service unregistered successfully.");
    }
}
