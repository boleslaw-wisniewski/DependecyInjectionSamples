package com.lab49.di.module;

import com.lab49.di.robotlegs.Leg;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;
import javax.inject.Named;

public class RightLegFactory implements Factory<Leg> {

    @Inject @Named("Samples.Right") ServiceLocator rightServiceLocator;

    @Right
    public Leg provide() {
        Leg rightLeg = rightServiceLocator.create(Leg.class);
        rightServiceLocator.inject(rightLeg);
        rightServiceLocator.postConstruct(rightLeg);

        return rightLeg;
    }


    public void dispose(Leg instance) {
        rightServiceLocator.preDestroy(instance);
    }
}
