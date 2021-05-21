package com.example.composite.order;

import com.example.composite.coffee.Coffees;

public class Serve {

    private final Coffees coffee;

    public Serve(Coffees cafe) {
        this.coffee = cafe;
    }

    public String print() {
        return String.format("주문 한 %s 커피", coffee);
    }
}
