package com.example.decorator.component;

import com.example.decorator.addtive.Component;

public class Espresso extends Component {

    private final String name;

    public Espresso() {
        this.name = "에소프레소";
    }

    @Override
    public double cost() {
        return 3_000;
    }

    @Override
    public String toString() {
        return name;
    }
}
