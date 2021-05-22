package com.example.decorator.component;

import com.example.decorator.Coffee;

public abstract class Decorator implements Coffee {

    protected final String name;

    protected Decorator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "커피";
    }
}
