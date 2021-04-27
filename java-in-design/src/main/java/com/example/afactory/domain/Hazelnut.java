package com.example.afactory.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

public class Hazelnut extends Coffee {

    private Milk milk;

    public Hazelnut(Milk milk) {
        super(new Bean(), new Water(100));
        this.milk = milk;
    }

    @Override
    public Coffee make() {
        return new Hazelnut(milk);
    }
}
