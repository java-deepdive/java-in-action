package com.example.factory.coffee;

public class AmericanoFactory extends CoffeeFactory {
    @Override
    protected Coffee makeCoffee() {
        return new Americano();
    }
}
