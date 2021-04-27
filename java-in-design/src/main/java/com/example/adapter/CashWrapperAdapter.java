package com.example.adapter;

import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

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
    public void calculate() {

    }

    @Override
    public void greet() {

    }
}
