package com.example.smart.home.sensors.motion;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Activator class for the Motion Sensor bundle.
 * This class manages the lifecycle of the bundle and registers the MotionSensorService
 * with the OSGi service registry upon bundle start.
 */
public class MotionSensorActivator implements BundleActivator {

    // Service registration object to manage the registration of the MotionSensorService
    private ServiceRegistration<?> registration;

    /**
     * Called by the OSGi framework when the Motion Sensor bundle is started.
     * This method registers the MotionSensorService with the OSGi service registry.
     *
     * @param context the execution context of the bundle being started.
     */
    @Override
    public void start(BundleContext context) throws Exception {
        // Create an instance of the MotionSensorServiceImpl
        MotionSensorService service = new MotionSensorServiceImpl();
        
        // Register the service with the OSGi framework using its class name
        registration = context.registerService(MotionSensorService.class.getName(), service, null);
        System.out.println("Motion Sensor Service registered successfully.");
    }

    /**
     * Called by the OSGi framework when the Motion Sensor bundle is stopped.
     * This method unregisters the MotionSensorService from the OSGi service registry.
     *
     * @param context the execution context of the bundle being stopped.
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        // Unregister the service
        registration.unregister();
        System.out.println("Motion Sensor Service unregistered successfully.");
    }
}
