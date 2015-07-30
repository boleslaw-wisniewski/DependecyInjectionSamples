package com.lab49.di.circular;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class CircularDagger
{
    @Provides
    MessageHandler provideMessageHandler(RepositoryClient repositoryClient) {
        return new MessageHandlerImpl(repositoryClient);
    }

    @Provides
    RepositoryClient provideRepositoryClient(ServiceClient serviceClient) {
        return new RepositoryClientImpl(serviceClient);
    }

    @Provides
    ServiceClient provideServiceClient() {
        return new ServiceClientImpl();
    }

    @Component(modules=CircularDagger.class)
    interface World {
        MessageHandler getMessageHandler();
    }

    public static void main(String[] arguments) {
        //WorldBuilder.builder()...
    }
}
