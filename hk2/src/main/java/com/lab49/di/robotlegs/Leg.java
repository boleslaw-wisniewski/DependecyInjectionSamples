package com.lab49.di.robotlegs;

import javax.inject.Inject;


public class Leg {
    @Inject BigToe bigToe;

    public BigToe getBigToe() {
        return bigToe;
    }
}
