package com.lab49.di.robotlegs;

import javax.inject.Inject;


public class Leg {
    @Inject Foot foot;

    public Foot getFoot() {
        return foot;
    }
}
