package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class Espresso extends Coffee {

    private Espresso(Builder builder) {
        super(builder.bean, builder.water);
    }

    @Override
    public Coffee make() {
        return new Espresso.Builder(bean, water).build();
    }

    public static class Builder {
        private final Bean bean;
        private final Water water;

        public Builder(Bean bean, Water water) {
            this.bean = bean;
            this.water = water;
        }

        public Espresso build() {
            return new Espresso(this);
        }
    }
}
