package com.example.decorator.component;


public class Americano extends Coffee {

    protected Americano(Espresso espresso) {
        super("아메리카노", espresso);
    }

    @Override
    public double cost() {
        return 4_000;
    }

    @Override
    public String toString() {
        return String.format("%s 커피", name);
    }
}
