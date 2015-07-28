package com.lab49.di.circular;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class Circular
{

    public static void main(String[] args)
    {
        ServiceLocator serviceLocator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
        AbstractBinder binder = new AbstractBinder() {
               @Override
               protected void configure() {
                     bind(ServiceClientImpl.class).to(ServiceClient.class);
                     bind(MessageHandlerImpl.class).to(MessageHandler.class);
                     bind(RepositoryClientImpl.class).to(RepositoryClient.class);
               }
        };
        ServiceLocatorUtilities.bind(serviceLocator, binder);
        MessageHandler instance = serviceLocator.getService(MessageHandler.class);
        System.err.println("MessageHandler=" + instance);
        System.err.println("RepositoryClient=" + ((MessageHandlerImpl)instance).handler);
        System.err.println("ServiceClient=" + ((RepositoryClientImpl)(((MessageHandlerImpl)instance).handler)).client);
        System.err.println("MessageHandler=" + ((ServiceClientImpl)(((RepositoryClientImpl)(((MessageHandlerImpl)instance).handler)).client)).handler);
    }

}
