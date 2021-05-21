package com.example.composite.coffee;

public class Espresso extends Coffee {
    public Espresso() {
        super("에소프레소");
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
