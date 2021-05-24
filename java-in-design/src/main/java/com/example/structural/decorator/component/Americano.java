package com.example.structural.decorator.component;


import com.example.structural.decorator.addtive.Component;

public class Americano extends Decorator {

    private final Component espresso;

    protected Americano(Component espresso) {
        super("아메리카노");
        this.espresso = espresso;
    }

    @Override
    public double cost() {
        return espresso.cost() + 1_000;
    }

    @Override
    public String toString() {
        return name;
    }
}
