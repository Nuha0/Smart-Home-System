package com.example.smart.home.sensors.light;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Activator class for the Light Sensor bundle.
 * Manages the lifecycle of the bundle and registers the LightSensorService with the OSGi service registry.
 */
public class LightSensorActivator implements BundleActivator {

    // Service registration object to manage the registration of the LightSensorService
    private ServiceRegistration<?> registration;

    /**
     * Called when the OSGi framework starts the bundle.
     * Registers the LightSensorService with the OSGi service registry.
     *
     * @param context the execution context of the bundle being started.
     */
    @Override
    public void start(BundleContext context) throws Exception {
        // Create an instance of the LightSensorServiceImpl
        LightSensorService service = new LightSensorServiceImpl();
        
        // Register the service with the OSGi framework
        registration = context.registerService(LightSensorService.class.getName(), service, null);
        System.out.println("Light Sensor Service registered successfully.");
    }

    /**
     * Called when the OSGi framework stops the bundle.
     * Unregisters the LightSensorService from the OSGi service registry.
     *
     * @param context the execution context of the bundle being stopped.
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        // Unregister the service
        registration.unregister();
        System.out.println("Light Sensor Service unregistered successfully.");
    }
}
