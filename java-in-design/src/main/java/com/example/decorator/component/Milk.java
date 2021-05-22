package com.example.decorator.component;

import com.example.decorator.addtive.Syrup;

public class Milk extends Syrup {

    public Milk() {
        super("우유");
    }

    @Override
    public double cost() {
        return 500;
    }

}
