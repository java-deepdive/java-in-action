package com.example.decorator.component;

public class Latte extends Coffee {

    protected final Milk milk;

    public Latte(Espresso espresso, Milk milk) {
        super("라떼", espresso);
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
