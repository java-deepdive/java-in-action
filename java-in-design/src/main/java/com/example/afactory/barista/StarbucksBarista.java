package com.example.afactory.barista;

import com.example.adapter.MakingCoffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import com.example.afactory.coffee.*;
import com.example.afactory.shop.Brand;

/**
 * Concrete Factory 역할
 */
public class StarbucksBarista implements BaristaManual, MakingCoffee {

    private final Brand brand = Brand.STARBUCKS;
    private final MakingCoffee makingCoffee;

    public StarbucksBarista(MakingCoffee makingCoffee) {
        this.makingCoffee = makingCoffee;
    }

    @Override
    public Coffee makeAmericano(Bean bean, Water water) {
        return new Americano.Builder(bean, water).build()
                .make();
    }

    @Override
    public Coffee makeEspresso(Bean bean, Water water) {
        return new Espresso.Builder(bean, water).build()
                .make();
    }

    @Override
    public Coffee makeMocha(Bean bean, Water water, Milk milk) {
        return new Mocha.Builder(bean, water).milk(milk).build()
                .make();
    }

    @Override
    public void offer() {
        makingCoffee.offer();
    }
}
