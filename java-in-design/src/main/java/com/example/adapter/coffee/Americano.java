package com.example.adapter.coffee;

public class Americano implements Coffee {

    @Override
    public Americano make() {
        return new Americano();
    }
}
