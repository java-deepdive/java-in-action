package com.example.decorator.component;

import com.example.decorator.addtive.Component;

public class MochaLatte extends Latte {

    private final Component component;

    public MochaLatte(Latte latte, Component component) {
        super(latte.espresso, latte.milk);
        this.component = component;
    }

    @Override
    public double cost() {
        return super.cost() + component.cost();
    }

    @Override
    public String toString() {
        return "모카" + super.toString();
    }
}
