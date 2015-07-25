package com.lab49.di.robotlegs;

import com.lab49.di.module.Left;
import com.lab49.di.module.Right;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/19/15
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
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
