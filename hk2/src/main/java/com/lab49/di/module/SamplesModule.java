package com.lab49.di.module;

import com.lab49.di.robotlegs.*;
import org.glassfish.hk2.api.DescriptorVisibility;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import static org.glassfish.hk2.api.DescriptorVisibility.LOCAL;
import static org.glassfish.hk2.utilities.BuilderHelper.createConstantDescriptor;
import static org.glassfish.hk2.utilities.ServiceLocatorUtilities.addOneDescriptor;
import static org.glassfish.hk2.utilities.ServiceLocatorUtilities.bind;


public class SamplesModule {

    ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();

    public ServiceLocator initialize() {

        ServiceLocator locator = factory.create("Samples");

        bind(locator, new RobotLegsBinder(factory, locator));
        return locator;
    }

    public static class RobotLegsBinder extends AbstractBinder {
        ServiceLocatorFactory factory;
        ServiceLocator parentLocator;

        RobotLegsBinder(ServiceLocatorFactory factory, ServiceLocator parentLocator) {
            this.factory = factory;
            this.parentLocator = parentLocator;
        }

        @Override
        protected void configure() {
            addActiveDescriptor(Foot.class);
            addActiveDescriptor(Body.class);
            //default BigToe implementation
            addOneDescriptor(parentLocator, BuilderHelper
                    .link(GnarlyBigToe.class)
                    .to(BigToe.class)
                    .in("org.glassfish.hk2.api.PerLookup")
                    .visibility(LOCAL)
                    .build()
            );

            createChildLocator("Samples.Left", GnarlyBigToe.class, LeftLegFactory.class,
                    "com.lab49.di.module.Left");
            createChildLocator("Samples.Right", HairyBigToe.class, RightLegFactory.class,
                    "com.lab49.di.module.Right");
        }

        private ServiceLocator createChildLocator(String locatorName,
                                                  Class<? extends BigToe> implementation,
                                                  Class factoryImplementation,
                                                  String annotation) {
            ServiceLocator childLocator = factory.create(locatorName, parentLocator);
            ServiceLocatorUtilities.addClasses(childLocator, Foot.class);
            ServiceLocatorUtilities.addClasses(childLocator, Body.class);
            //add child locator so we can inject it
            addOneDescriptor(
                    parentLocator,
                    createConstantDescriptor(childLocator, locatorName, ServiceLocator.class)
            );
            //bind child specific implementation of BigToe
            addOneDescriptor(childLocator, BuilderHelper
                    .link(implementation)
                    .to(BigToe.class)
                    .in("org.glassfish.hk2.api.PerLookup")
                    .build()
            );
            //bind the annotated Leg Factory
            bind(BuilderHelper
                .link(factoryImplementation)
                .to(Leg.class)
                .qualifiedBy(annotation)
                .in("org.glassfish.hk2.api.PerLookup")
                .buildFactory());
            return childLocator;
        }
    }

}
