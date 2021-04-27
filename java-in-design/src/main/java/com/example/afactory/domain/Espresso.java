package com.example.afactory.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class Espresso extends Coffee {
    public Espresso() {
        super(new Bean(), new Water(100));
    }

    @Override
    public Coffee make() {
        return new Espresso();
    }
}
