package com.lab49.di.sample;


import com.lab49.di.module.SamplesModule;
import com.lab49.di.robotlegs.Body;
import org.glassfish.hk2.api.ServiceLocator;

public class HK2SampleApp {

    public static void main(String[] args) {
        ServiceLocator locator = new SamplesModule().initialize();

        useRobotLegs(locator);
    }

    private static void useRobotLegs(ServiceLocator locator) {
        Body body = locator.getService(Body.class);
        System.out.println("Left leg: " + body.getLeftLeg().getFoot().getBigToe().getClass().getSimpleName());
        System.out.println("Right leg: " + body.getRightLeg().getFoot().getBigToe().getClass().getSimpleName());
    }
}
