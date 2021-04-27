package com.example.afactory.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public abstract class Coffee implements Cloneable {

    protected final Bean bean;
    protected final Water water;

    protected Coffee(Bean bean, Water water) {
        this.bean = bean;
        this.water = water;
    }

    protected abstract Coffee make();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
