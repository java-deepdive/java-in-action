package com.example.factory.coffee;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import com.example.domain.Americano;
import com.example.domain.Coffee;

public class AmericanoFactory extends CoffeeFactory {
    @Override
    protected Coffee makeCoffee() {
        return new Americano.Builder(new Bean(), Water.regular()).build();
    }
}
