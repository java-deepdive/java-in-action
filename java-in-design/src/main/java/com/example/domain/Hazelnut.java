package com.example.domain;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;

import java.util.Objects;

public class Hazelnut extends Coffee {

    private final Milk milk;

    public Hazelnut(Builder builder) {
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

        public Hazelnut build() {
            return new Hazelnut(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hazelnut)) return false;
        if (!super.equals(o)) return false;
        final Hazelnut hazelnut = (Hazelnut) o;
        return Objects.equals(milk, hazelnut.milk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milk);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", bean, water, milk);
    }
}
