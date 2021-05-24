package com.example.structural.flyweight.concrete;

import com.example.structural.flyweight.Flyweight;

public class UnsharedConcreteFlyweight implements Flyweight {

    private final Object state;

    public UnsharedConcreteFlyweight(Object state) {
        this.state = state;
    }

    public void operation(Object extrinsicState) {

    }

    public Object getState() {
        return state;
    }
}
