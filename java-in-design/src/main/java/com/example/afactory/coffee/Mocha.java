package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

import java.util.Objects;

public class Mocha extends Coffee {

    private final Milk milk;

    private Mocha(Builder builder) {
        super(builder.bean, builder.water);
        milk = builder.milk;
    }

    @Override
    public Coffee make() {
        return new Mocha.Builder(bean, water).milk(milk).build();
    }

    public static class Builder {
        private final Bean bean;
        private final Water water;
        private Milk milk;

        public Builder(Bean bean, Water water) {
            this.bean = bean;
            this.water = water;
        }

        public Builder milk(Milk milk) {
            this.milk = milk;
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
