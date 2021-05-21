package com.example.composite.coffee;

public class Mocha extends Coffee {
    public Mocha() {
        super("모카라떼");
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
