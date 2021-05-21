package com.example.composite.coffee;

public class Americano extends Coffee {
    public Americano() {
        super("아메리카노");
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
