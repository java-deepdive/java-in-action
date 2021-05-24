package com.example.creational.afactory.barista;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.domain.*;

public class TomNTomsBarista implements BaristaManual {

    private final Brand brand = Brand.TOM_N_TOMS;

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
