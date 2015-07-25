package com.lab49.di.sample;

import com.google.inject.*;
import com.lab49.di.module.Left;
import com.lab49.di.module.Right;
import com.lab49.di.module.SamplesModule;
import com.lab49.di.robotlegs.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/19/15
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuiceSampleApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SamplesModule());

        Body body = injector.getInstance(Body.class);
        useRobotLegs(body);
    }

    private static void useRobotLegs(Body body) {
        System.out.println("Left leg: " + body.getLeftLeg().getFoot().getBigToe().getClass().getSimpleName());
        System.out.println("Right leg: " + body.getRightLeg().getFoot().getBigToe().getClass().getSimpleName());
    }
}
