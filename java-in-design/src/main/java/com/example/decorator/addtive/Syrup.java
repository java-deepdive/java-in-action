package com.example.decorator.addtive;

public abstract class Syrup implements CoffeeDecorator {

    protected final String name;

    protected Syrup(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " 시럽";
    }
}
