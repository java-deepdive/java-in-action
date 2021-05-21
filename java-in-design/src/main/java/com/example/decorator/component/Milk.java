package com.example.decorator.component;

import com.example.decorator.Cost;

public class Milk implements Cost {
    @Override
    public double cost() {
        return 500;
    }
}
