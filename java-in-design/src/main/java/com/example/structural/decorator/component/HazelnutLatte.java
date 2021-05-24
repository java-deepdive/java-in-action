package com.example.structural.decorator.component;

import com.example.structural.decorator.addtive.Component;

public class HazelnutLatte extends Latte {

    private final Component hazelnut;

    public HazelnutLatte(Component espresso, Component milk, Component hazelnut) {
        super(espresso, milk);
        this.hazelnut = hazelnut;
    }

    @Override
    public double cost() {
        return super.cost() + hazelnut.cost() + 500;
    }

    @Override
    public String toString() {
        return hazelnut + name;
    }
}
