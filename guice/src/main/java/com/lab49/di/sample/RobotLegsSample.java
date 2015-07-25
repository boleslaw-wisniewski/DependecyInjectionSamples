package com.lab49.di.sample;

import com.google.inject.*;
import com.lab49.di.module.Left;
import com.lab49.di.module.Right;
import com.lab49.di.robotlegs.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/19/15
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotLegsSample {

    /*
    Within private modules, only bindings that are explicitly exposed will be available to other modules and to the users of the injector.
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new AbstractModule() {
                            @Override
                            protected void configure() {
                                /* One limitation is that guice won't allow global "default" bindings if classes are already
                                *  bound within a private module
                                *  bind(BigToe.class).to(GnarlyBigToe.class);
                                *  */
                            }
                },
                new PrivateModule() {
                    @Override
                    protected void configure() {
                        bind(Leg.class).annotatedWith(Left.class).to(Leg.class);
                        expose(Leg.class).annotatedWith(Left.class);

                        bind(BigToe.class).to(GnarlyBigToe.class);
                    }
                },
                new PrivateModule() {
                    @Override
                    protected void configure() {
                        bind(Leg.class).annotatedWith(Right.class).to(Leg.class);
                        expose(Leg.class).annotatedWith(Right.class);

                        bind(BigToe.class).to(HairyBigToe.class);
                    }
                });

        Body body = injector.getInstance(Body.class);
        System.out.println("Left leg: " + body.getLeftLeg().getBigToe().getClass().getSimpleName());
        System.out.println("Right leg: " + body.getRightLeg().getBigToe().getClass().getSimpleName());
    }
}
