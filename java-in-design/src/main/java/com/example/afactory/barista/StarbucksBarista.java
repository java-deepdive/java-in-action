package com.example.afactory.barista;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;
import com.example.domain.*;

/**
 * Concrete Factory 역할
 * Service 역할
 */
public class StarbucksBarista implements BaristaManual {

    private final Brand brand = Brand.STARBUCKS;

    @Override
    public Coffee makeAmericano(Bean bean, Water water) {
        return new Americano.Builder(bean, water).build();
    }

    @Override
    public Coffee makeEspresso(Bean bean, Water water) {
        return new Espresso.Builder(bean, water).build();
    }

    @Override
    public Coffee makeMocha(Bean bean, Water water, Milk milk) {
        return new Mocha.Builder(bean, water).milk(milk).build();
    }
}
