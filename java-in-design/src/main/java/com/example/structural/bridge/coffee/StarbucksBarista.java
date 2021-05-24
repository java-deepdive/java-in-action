package com.example.structural.bridge.coffee;

import com.example.domain.Coffee;

public class StarbucksBarista extends Barista {

    StarbucksBarista(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Coffee makeCoffee() {
        return null;
    }
}
