package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class GsonCoffee extends Coffee {
    protected GsonCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }
}
