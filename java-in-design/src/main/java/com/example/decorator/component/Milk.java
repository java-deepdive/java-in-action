package com.example.decorator.component;

import com.example.decorator.addtive.Component;

public class Milk extends Component {

    public Milk() {
        super("우유");
    }

    @Override
    public double cost() {
        return 500;
    }

}
