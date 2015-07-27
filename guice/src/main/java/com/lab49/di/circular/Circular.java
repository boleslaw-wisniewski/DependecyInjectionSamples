package com.lab49.di.circular;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Circular {

    public static void main(String[] arg) {
        
        Module module = new AbstractModule()
        {
            @Override
            protected void configure()
            {
                bind(MessageHandler.class).to(MessageHandlerImpl.class);
                bind(RepositoryClient.class).to(RepositoryClientImpl.class);
                bind(ServiceClient.class).to(ServiceClientImpl.class);
            }
        };
        Injector injector = Guice.createInjector(module);
        MessageHandler instance = injector.getInstance(MessageHandler.class);
        System.err.println("MessageHandler=" + instance);
        System.err.println("RepositoryClient=" + ((MessageHandlerImpl)instance).handler);
        System.err.println("ServiceClient=" + ((RepositoryClientImpl)(((MessageHandlerImpl)instance).handler)).client);
        System.err.println("MessageHandler=" + ((ServiceClientImpl)(((RepositoryClientImpl)(((MessageHandlerImpl)instance).handler)).client)).handler);
    }
}
