package com.example.structural.composite.coffee;

import com.example.structural.composite.barista.CoffeeFactory;
import com.example.structural.composite.order.MenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coffees {

    private final List<Coffee> coffees;

    public Coffees(MenuItem... menuItems) {
        this.coffees = Arrays.stream(menuItems)
                .map(CoffeeFactory::menu)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.valueOf(coffees);
    }
}
