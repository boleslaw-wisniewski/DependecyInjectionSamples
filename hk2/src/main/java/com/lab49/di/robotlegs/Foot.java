package com.lab49.di.robotlegs;

import javax.inject.Inject;


public class Foot {
    @Inject BigToe bigToe;

    public BigToe getBigToe() {
        return bigToe;
    }
}
