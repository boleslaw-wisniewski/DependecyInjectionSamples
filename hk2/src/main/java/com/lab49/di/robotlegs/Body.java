package com.lab49.di.robotlegs;

import javax.inject.Inject;


public class Body {
    @Inject Leg leftLeg;
    @Inject Leg rightLeg;

    public Leg getLeftLeg() {
        return leftLeg;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }
}
