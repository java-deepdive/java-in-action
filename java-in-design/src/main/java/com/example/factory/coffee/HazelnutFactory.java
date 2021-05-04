package com.example.factory.coffee;

public class HazelnutFactory extends CoffeeFactory {
    @Override
    protected Coffee makeCoffee() {
        return new HazelnutCoffee();
    }
}
