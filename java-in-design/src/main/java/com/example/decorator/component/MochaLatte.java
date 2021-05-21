package com.example.decorator.component;

import com.example.decorator.addtive.Syrup;

public class MochaLatte extends Latte {

    private final Syrup syrup;

    public MochaLatte(Latte latte, Syrup syrup) {
        super(latte.espresso, latte.milk);
        this.syrup = syrup;
    }

    @Override
    public double cost() {
        return super.cost() + syrup.cost();
    }
}
