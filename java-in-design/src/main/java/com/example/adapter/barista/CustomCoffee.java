package com.example.adapter.barista;

import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class CustomCoffee extends Coffee {

    private final Coffee spacialCoffee;

    protected CustomCoffee(Bean bean, Water water, Coffee spacialCoffee) {
        super(bean, water);
        this.spacialCoffee = spacialCoffee;
    }

    @Override
    protected Coffee make() {
        return new CustomCoffee(bean, water, spacialCoffee);
    }
}
