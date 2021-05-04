package com.example.factory.coffee;

/**
 * Creator
 */
public abstract class CoffeeFactory {

    protected abstract Coffee makeCoffee();

    public Coffee distribute() {
        return makeCoffee();
    }
}
