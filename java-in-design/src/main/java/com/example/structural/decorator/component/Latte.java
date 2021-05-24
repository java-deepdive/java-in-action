package com.example.structural.decorator.component;

import com.example.structural.decorator.addtive.Component;

public class Latte extends Decorator {

    protected final Component milk;
    protected final Component espresso;

    public Latte(Component espresso, Component milk) {
        super("라떼");
        this.espresso = espresso;
        this.milk = milk;
    }

    @Override
    public double cost() {
        return espresso.cost() + milk.cost() + 500;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
