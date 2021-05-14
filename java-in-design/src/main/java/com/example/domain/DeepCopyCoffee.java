package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class DeepCopyCoffee extends Coffee {

    public DeepCopyCoffee(DeepCopyCoffee coffee) {
        this(coffee.bean, coffee.water, coffee.brand);
    }

    protected DeepCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    @Override
    public DeepCopyCoffee clone() {
        return new DeepCopyCoffee(this);
    }
}
