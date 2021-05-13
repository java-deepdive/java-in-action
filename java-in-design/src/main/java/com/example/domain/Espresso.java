package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class Espresso extends Coffee {

    private Espresso(Builder builder) {
        super(builder.bean, builder.water, builder.brand);
    }

    public static class Builder {
        private final Bean bean;
        private final Water water;
        private Brand brand;

        public Builder(Bean bean, Water water) {
            this.bean = bean;
            this.water = water;
        }

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Espresso build() {
            return new Espresso(this);
        }
    }

    @Override
    public Espresso clone() {
        return (Espresso) super.clone();
    }
}
