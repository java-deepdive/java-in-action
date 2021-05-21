package com.example.decorator.component;

import com.example.decorator.Cost;

public class Espresso implements Cost {

    @Override
    public double cost() {
        return 4_000;
    }
}
