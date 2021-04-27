package com.example.adapter.barista;

import com.example.adapter.Cashier;
import com.example.afactory.barista.BaristaManual;
import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Milk;
import com.example.afactory.component.Water;

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
