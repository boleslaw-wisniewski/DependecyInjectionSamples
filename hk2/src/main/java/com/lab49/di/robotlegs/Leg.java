package com.lab49.di.robotlegs;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/19/15
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Leg {
    @Inject BigToe bigToe;

    public BigToe getBigToe() {
        return bigToe;
    }
}
