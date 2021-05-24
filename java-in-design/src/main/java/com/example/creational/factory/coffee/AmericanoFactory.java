package com.example.creational.factory.coffee;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Water;
import com.example.domain.Americano;
import com.example.domain.Coffee;

public class AmericanoFactory extends CoffeeFactory {
    @Override
    protected Coffee makeCoffee() {
        return new Americano.Builder(new Bean(), Water.regular()).build();
    }
}
