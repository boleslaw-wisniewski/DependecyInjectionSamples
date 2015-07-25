package com.lab49.di.robotlegs;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/25/15
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Foot {
    @Inject BigToe bigToe;

    public BigToe getBigToe() {
        return bigToe;
    }
}
