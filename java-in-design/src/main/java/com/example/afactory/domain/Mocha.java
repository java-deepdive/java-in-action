package com.example.afactory.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

public class Mocha extends Coffee {

    private Milk milk;

    public Mocha() {
        super(new Bean(), new Water(100));
    }

    @Override
    public Coffee make() {
        return new Mocha();
    }
}
