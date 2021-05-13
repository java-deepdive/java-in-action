package com.example.adapter.coffee;

public class Espresso implements Coffee {

    @Override
    public Espresso make() {
        return new Espresso();
    }
}
