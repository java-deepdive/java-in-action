package com.example.decorator.component;

import com.example.decorator.addtive.Component;

public class Espresso extends Component {

    public Espresso() {
        super("에소프레소");
    }

    @Override
    public double cost() {
        return 4_000;
    }
}
