package com.example.smart.home.services.security;

import com.example.smart.home.sensors.motion.MotionSensorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

/**
 * Activator class for the Security System bundle.
 * This class listens for the registration and unregistration of MotionSensorService
 * and manages the security system based on motion detection.
 */
public class SecuritySystemActivator implements BundleActivator, ServiceListener {

    private BundleContext context;
    private boolean systemArmed = false; // Simplified state management for demonstration

    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
        // Add this activator as a service listener specifically for the MotionSensorService
        String filter = "(objectclass=" + MotionSensorService.class.getName() + ")";
        context.addServiceListener(this, filter);
        System.out.println("Security System Activator started. Listening for MotionSensorService...");
        
        // Simplified method to arm the system. In a real scenario, this would be more dynamic.
        systemArmed = true; // Assume the system is armed for demonstration purposes
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.removeServiceListener(this);
        System.out.println("Security System Activator stopped.");
    }

    @Override
    public void serviceChanged(ServiceEvent event) {
        ServiceReference<?> serviceReference = event.getServiceReference();
        Object service = context.getService(serviceReference);

        if (service instanceof MotionSensorService) {
            MotionSensorService motionSensorService = (MotionSensorService) service;
            switch (event.getType()) {
                case ServiceEvent.REGISTERED:
                    System.out.println("MotionSensorService registered. Security system is monitoring for motion.");
                    if (systemArmed && motionSensorService.isMotionDetected()) {
                        // Trigger an alarm or notification
                        System.out.println("Motion detected! Security alert!");
                    }
                    break;
                case ServiceEvent.UNREGISTERING:
                    System.out.println("MotionSensorService unregistered. Security system will stop monitoring.");
                    context.ungetService(serviceReference);
                    break;
            }
        }
    }
}
