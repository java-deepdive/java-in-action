package com.example.adapter.coffee;

public class StarbucksBaristaAdapter implements AdvancedCoffee {
    Coffee coffee;

    @Override
    public Coffee make() {
        return coffee.make();
    }
}
