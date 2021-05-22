package com.example.decorator.component;

import com.example.decorator.Coffee;
import com.example.decorator.addtive.Component;

public abstract class Decorator extends Component implements Coffee {

    protected final String name;

    protected Decorator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "커피";
    }
}
