package com.lab49.di.module;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;


public class SamplesModule {

    public void initialize() {
            ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();

            ServiceLocator locator = factory.create("Samples");
            DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);


        }

}
