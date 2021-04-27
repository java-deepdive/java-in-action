package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class Americano extends Coffee {

    private Americano(Builder builder) {
        super(builder.bean, builder.water);
    }

    @Override
    public Coffee make() {
        return new Americano.Builder(bean, water).build();
    }

    public static class Builder {
        private final Bean bean;
        private final Water water;

        public Builder(Bean bean, Water water) {
            this.bean = bean;
            this.water = water;
        }

        public Americano build() {
            return new Americano(this);
        }
    }
}
