package com.example.structural.composite.order;

import com.example.structural.composite.coffee.Coffees;

// view에 관련된 내용을 담을 클래스
public class Serve {

    private final Coffees coffee;

    public Serve(Coffees cafe) {
        this.coffee = cafe;
    }

    public String print() {
        return String.format("주문 한 %s 커피", coffee);
    }
}
