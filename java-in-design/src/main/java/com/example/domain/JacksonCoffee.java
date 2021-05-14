package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class JacksonCoffee extends Coffee {

    private JacksonCoffee() {
        this(null, null, null);
    }

    protected JacksonCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    @Override
    public String toString() {
        return "JacksonCoffee{" +
                "bean=" + bean +
                ", water=" + water +
                ", brand=" + brand +
                '}';
    }
}
