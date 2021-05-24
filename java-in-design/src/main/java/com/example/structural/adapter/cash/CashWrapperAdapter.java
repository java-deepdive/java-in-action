package com.example.structural.adapter.cash;

import com.example.creational.afactory.barista.StarbucksBarista;
import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.domain.Coffee;

public class CashWrapperAdapter extends StarbucksBarista implements Cashier {

    @Override
    public Coffee makeAmericano(Bean bean, Water water) {
        return super.makeAmericano(bean, water);
    }

    @Override
    public Coffee makeEspresso(Bean bean, Water water) {
        return super.makeEspresso(bean, water);
    }

    @Override
    public Coffee makeMocha(Bean bean, Water water, Milk milk) {
        return super.makeMocha(bean, water, milk);
    }

    @Override
    public void calculate(int money) {

    }

    @Override
    public void greet() {

    }
}
