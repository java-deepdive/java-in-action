package com.example.decorator.component;

import com.example.decorator.Cost;
import com.example.decorator.component.Espresso;

public abstract class Coffee implements Cost {

    protected final String name;
    protected final Espresso espresso;

    protected Coffee(String name, Espresso espresso) {
        this.name = name;
        this.espresso = espresso;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
