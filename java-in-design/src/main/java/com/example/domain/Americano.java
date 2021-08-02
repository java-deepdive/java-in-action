package com.example.domain;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Water;

public class Americano extends Coffee {

    private Americano(Builder builder) {
        super(builder.bean, builder.water, builder.brand);
    }

    @Override
    public Coffee clone() {
        return new Americano.Builder(bean, water).build();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", bean, water, brand);
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

        public Americano build() {
            return new Americano(this);
        }
    }
}
