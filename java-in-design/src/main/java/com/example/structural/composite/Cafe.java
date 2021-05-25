package com.example.structural.composite;

import com.example.structural.composite.coffee.Coffees;
import com.example.structural.composite.order.MenuItem;
import com.example.structural.composite.order.Serve;

public class Cafe {

    private final Coffees coffee;

    private Cafe(MenuItem... menuItems) {
        this.coffee = new Coffees(menuItems);
    }

    public static Cafe orders(MenuItem... menuItems) {
        return new Cafe(menuItems);
    }

    // Extractor
    public Serve menuServe() {
        return new Serve(coffee);
    }
}
