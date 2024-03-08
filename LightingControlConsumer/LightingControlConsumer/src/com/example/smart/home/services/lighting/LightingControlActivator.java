package com.example.smart.home.services.lighting;

import com.example.smart.home.sensors.light.LightSensorService;
import com.example.smart.home.sensors.motion.MotionSensorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

/**
 * Activator class for the Lighting Control bundle.
 * This class listens for the registration and unregistration of LightSensorService and MotionSensorService,
 * and controls the lighting based on the data from these sensors.
 */
public class LightingControlActivator implements BundleActivator, ServiceListener {

    private BundleContext context;

    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
        // Listen for both LightSensorService and MotionSensorService
        String filter = "(|(objectclass=" + LightSensorService.class.getName() + ")(objectclass=" + MotionSensorService.class.getName() + "))";
        context.addServiceListener(this, filter);
        System.out.println("Lighting Control Activator started. Listening for sensor services...");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.removeServiceListener(this);
        System.out.println("Lighting Control Activator stopped.");
    }

    @Override
    public void serviceChanged(ServiceEvent event) {
        ServiceReference<?> serviceReference = event.getServiceReference();
        Object service = context.getService(serviceReference);

        switch (event.getType()) {
            case ServiceEvent.REGISTERED:
                System.out.println("Service registered: " + service.getClass().getName());
                if (service instanceof LightSensorService) {
                    // Handle light sensor registration
                    LightSensorService lightSensorService = (LightSensorService) service;
                    // Logic to adjust lighting based on light level
                } else if (service instanceof MotionSensorService) {
                    // Handle motion sensor registration
                    MotionSensorService motionSensorService = (MotionSensorService) service;
                    // Logic to adjust lighting based on motion detection
                }
                break;
            case ServiceEvent.UNREGISTERING:
                System.out.println("Service unregistered: " + service.getClass().getName());
                context.ungetService(serviceReference);
                // Handle service unregistration if necessary
                break;
        }
    }
}
