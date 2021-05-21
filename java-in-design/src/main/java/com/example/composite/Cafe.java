package com.example.composite;

import com.example.composite.coffee.Coffees;
import com.example.composite.order.MenuItem;
import com.example.composite.order.Serve;

public class Cafe {

    private final Coffees coffee;

    private Cafe(MenuItem... menuItems) {
        this.coffee = new Coffees(menuItems);
    }

    public static Cafe orders(MenuItem... menuItems) {
        return new Cafe(menuItems);
    }

    public Serve menuServe() {
        return new Serve(coffee);
    }
}
