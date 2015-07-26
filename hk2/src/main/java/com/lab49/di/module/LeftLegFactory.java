package com.lab49.di.module;

import com.lab49.di.robotlegs.Leg;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;
import javax.inject.Named;

public class LeftLegFactory implements Factory<Leg> {

    @Inject @Named("Samples.Left") ServiceLocator leftServiceLocator;

    @Left
    public Leg provide() {
        Leg leftLeg = leftServiceLocator.create(Leg.class);
        leftServiceLocator.inject(leftLeg);
        leftServiceLocator.postConstruct(leftLeg);

        return leftLeg;
    }


    public void dispose(Leg instance) {
        leftServiceLocator.preDestroy(instance);
    }
}
