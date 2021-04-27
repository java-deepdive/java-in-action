package com.example.afactory.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class Americano extends Coffee {

    public Americano() {
        super(new Bean(), new Water(100));
    }

    @Override
    public Coffee make() {
        return new Americano();
    }

    @Override
    public Americano clone() {
        try {
            return (Americano) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
