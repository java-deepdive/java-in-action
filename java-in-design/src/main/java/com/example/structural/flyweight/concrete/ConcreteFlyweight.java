package com.example.structural.flyweight.concrete;

import com.example.structural.flyweight.Flyweight;

public class ConcreteFlyweight implements Flyweight {

    private final Object intrinsicState;

    public ConcreteFlyweight(Object intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    // Using extrinsicState as context and does NOT modify intrinsic state.
    public void operation(Object extrinsicState) {
    }

    /**
     * @return intrinsic state
     */
    public Object getIntrinsicState() {
        return intrinsicState;
    }
}
