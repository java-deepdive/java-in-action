package com.example.bridge.coffee;

import com.example.domain.Coffee;

public abstract class Barista {

    protected final Coffee coffee;

    Barista(Coffee coffee) {
        this.coffee = coffee;
    }

    protected abstract Coffee makeCoffee();
}
