package com.lab49.di.module;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.lab49.di.robotlegs.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/25/15
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class SamplesModule extends AbstractModule{
    @Override
    protected void configure() {
        bindRobotLegs();
    }

    private void bindRobotLegs() {

        //we don't need to bind concrete instances
        //bind(Foot.class).to(Foot.class);

        /*Within private modules, only bindings that are explicitly exposed will be available to other modules and to
        the users of the injector.*/
        install(new PrivateModule() {
            @Override
            protected void configure() {
                bind(Leg.class).annotatedWith(Left.class).to(Leg.class);
                expose(Leg.class).annotatedWith(Left.class);

                //private modules inherit bindings from their parents, so the implicit foot binding works here
                bind(BigToe.class).to(GnarlyBigToe.class);
            }
        });
        install(new PrivateModule() {
            @Override
            protected void configure() {
                bind(Leg.class).annotatedWith(Right.class).to(Leg.class);
                expose(Leg.class).annotatedWith(Right.class);

                bind(BigToe.class).to(HairyBigToe.class);
            }
        });

        /* One limitation is that guice won't allow global "default" bindings if classes are already
        *  bound within a private module. In our example we can't bind Leg without an annotation.
        *  */
    }
}
