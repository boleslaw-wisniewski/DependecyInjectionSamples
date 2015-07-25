package com.lab49.di.robotlegs;

import com.lab49.di.module.Left;
import com.lab49.di.module.Right;

import javax.inject.Inject;


public class Body {
    @Inject @Left Leg leftLeg;
    @Inject @Right Leg rightLeg;

    public Leg getLeftLeg() {
        return leftLeg;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }
}
