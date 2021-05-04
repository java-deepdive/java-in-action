package com.example.adapter.barista;

import com.example.afactory.coffee.Americano;
import com.example.afactory.coffee.Coffee;
import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public abstract class Barista {

    public Coffee makeCoffee() {
        return new CustomCoffee(new Bean(), Water.regular(), new Americano.Builder(new Bean(), Water.regular()).build());
    }
}
