package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

import java.util.Objects;

public class Mocha extends Coffee {

    private final Milk milk;

    private Mocha(Builder builder) {
        super(builder.bean, builder.water, builder.brand);
        this.milk = builder.milk;
    }

    public static class Builder {
        private final Bean bean;
        private final Water water;
        private Milk milk;
        private Brand brand;

        public Builder(Bean bean, Water water) {
            this.bean = bean;
            this.water = water;
        }

        public Builder milk(Milk milk) {
            this.milk = milk;
            return this;
        }

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Mocha build() {
            return new Mocha(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mocha)) return false;
        final Mocha mocha = (Mocha) o;
        return Objects.equals(milk, mocha.milk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(milk);
    }

}
