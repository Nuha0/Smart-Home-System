package com.example.smart.home.services.hvac;

import com.example.smart.home.sensors.temperature.TemperatureSensorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 * Activator class for the HVAC Control bundle.
 * This class listens for the registration and unregistration of the TemperatureSensorService
 * and controls the HVAC system based on the temperature data.
 */
public class HVACActivator implements BundleActivator, ServiceListener {

    private BundleContext context;
    private TemperatureSensorService temperatureSensorService;

    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
        // Add this activator as a service listener to listen for TemperatureSensorService events
        String filter = "(objectclass=" + TemperatureSensorService.class.getName() + ")";
        context.addServiceListener(this, filter);
        System.out.println("HVAC Activator started. Listening for TemperatureSensorService...");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // Clean up: Remove service listener
        context.removeServiceListener(this);
        System.out.println("HVAC Activator stopped.");
    }

    @Override
    public void serviceChanged(ServiceEvent event) {
        switch (event.getType()) {
            case ServiceEvent.REGISTERED:
                // Service registered: Obtain a reference to the service
                temperatureSensorService = (TemperatureSensorService) context.getService(event.getServiceReference());
                System.out.println("TemperatureSensorService registered. HVAC Control can start.");
                // Here, you could use temperatureSensorService.getCurrentTemperature() to control the HVAC system
                break;
            case ServiceEvent.UNREGISTERING:
                // Service unregistered: Clean up and release the service reference
                context.ungetService(event.getServiceReference());
                temperatureSensorService = null;
                System.out.println("TemperatureSensorService unregistered. HVAC Control will stop.");
                break;
        }
    }
}
