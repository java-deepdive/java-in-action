package com.example.adapter.barista;

import com.example.afactory.barista.StarbucksBarista;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class StarbucksCustomBarista extends Barista {

    private final StarbucksBarista starbucksBarista;

    public StarbucksCustomBarista(StarbucksBarista starbucksBarista) {
        this.starbucksBarista = starbucksBarista;
    }

    @Override
    public Coffee makeCoffee() {
        Coffee coffee = starbucksBarista.makeAmericano(new Bean(), Water.regular());
        return new CustomCoffee(new Bean(), Water.small(), coffee);
    }
}
