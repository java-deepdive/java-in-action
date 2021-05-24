package com.example.creational.factory.coffee;

import com.example.creational.afactory.component.Bean;
import com.example.creational.afactory.component.Milk;
import com.example.creational.afactory.component.Water;
import com.example.domain.Coffee;
import com.example.domain.Hazelnut;

public class HazelnutFactory extends CoffeeFactory {
    @Override
    protected Coffee makeCoffee() {
        return new Hazelnut.Builder(new Bean(), Water.regular()).milk(Milk.regular()).build();
    }
}
