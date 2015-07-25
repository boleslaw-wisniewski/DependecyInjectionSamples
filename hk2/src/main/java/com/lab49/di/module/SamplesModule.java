package com.lab49.di.module;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/25/15
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class SamplesModule {

    public void initialize() {
            ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();

            ServiceLocator locator = factory.create("Samples");
            DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);


        }

}
