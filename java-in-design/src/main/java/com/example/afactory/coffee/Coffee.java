package com.example.afactory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

import java.util.Objects;

public abstract class Coffee {

    protected final Bean bean;
    protected final Water water;

    protected Coffee(Bean bean, Water water) {
        this.bean = bean;
        this.water = water;
    }

    protected abstract Coffee make();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        final Coffee coffee = (Coffee) o;
        return Objects.equals(bean, coffee.bean)
                && Objects.equals(water, coffee.water);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bean, water);
    }
}
