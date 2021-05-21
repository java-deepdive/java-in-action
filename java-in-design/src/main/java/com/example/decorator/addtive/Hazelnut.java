package com.example.decorator.addtive;

public class Hazelnut extends Syrup {

    protected Hazelnut() {
        super("헤이즐넛");
    }

    @Override
    public double cost() {
        return 500;
    }

    @Override
    public String desc() {
        return super.toString();
    }
}
