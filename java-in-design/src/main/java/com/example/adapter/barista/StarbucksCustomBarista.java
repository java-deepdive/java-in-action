package com.example.adapter.barista;

import com.example.adapter.cash.Cashier;
import com.example.afactory.barista.StarbucksBarista;

public class StarbucksCustomBarista implements Cashier {

    private final StarbucksBarista starbucksBarista;

    public StarbucksCustomBarista(StarbucksBarista starbucksBarista) {
        this.starbucksBarista = starbucksBarista;
    }

    @Override
    public void calculate() {

    }

    @Override
    public void greet() {

    }
}
