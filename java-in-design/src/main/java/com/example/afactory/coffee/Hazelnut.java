package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

public class Hazelnut extends Coffee {

    private final Milk milk;

    public Hazelnut(Milk milk) {
        super(new Bean(), Water.small());
        this.milk = milk;
    }

    @Override
    public Coffee make() {
        return new Hazelnut(milk);
    }
}
