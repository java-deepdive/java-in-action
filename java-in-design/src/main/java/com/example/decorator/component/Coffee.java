package com.example.decorator.component;

public abstract class Coffee {

    protected final String name;
    protected final Espresso espresso;

    protected Coffee(String name, Espresso espresso) {
        this.name = name;
        this.espresso = espresso;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
