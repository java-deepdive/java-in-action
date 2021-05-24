package com.example.creational.factory.coffee;

import com.example.domain.Coffee;

/**
 * Creator
 */
public abstract class CoffeeFactory {

    protected abstract Coffee makeCoffee();

    public Coffee distribute() {
        return makeCoffee();
    }
}
