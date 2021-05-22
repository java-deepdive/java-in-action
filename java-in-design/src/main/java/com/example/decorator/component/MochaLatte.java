package com.example.decorator.component;

import com.example.decorator.addtive.Component;

public class MochaLatte extends Latte {

    private final Component mocha;

    public MochaLatte(Latte latte, Component mocha) {
        super(latte.espresso, latte.milk);
        this.mocha = mocha;
    }

    @Override
    public double cost() {
        return super.cost() + mocha.cost();
    }

    @Override
    public String toString() {
        return mocha + name;
    }
}
