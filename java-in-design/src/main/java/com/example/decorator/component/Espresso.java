package com.example.decorator.component;

import com.example.decorator.addtive.Syrup;

public class Espresso extends Syrup {

    public Espresso() {
        super("에소프레소");
    }

    @Override
    public double cost() {
        return 4_000;
    }
}
