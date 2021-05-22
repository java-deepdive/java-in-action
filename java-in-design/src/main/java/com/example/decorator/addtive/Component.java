package com.example.decorator.addtive;

public abstract class Component implements CoffeeDecorator {

    protected final String name;

    protected Component(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " 시럽";
    }
}
