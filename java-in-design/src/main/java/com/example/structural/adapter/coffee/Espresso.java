package com.example.structural.adapter.coffee;

public class Espresso implements Coffee {

    @Override
    public Espresso make() {
        return new Espresso();
    }
}
