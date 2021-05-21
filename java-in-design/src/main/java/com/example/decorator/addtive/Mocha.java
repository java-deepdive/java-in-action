package com.example.decorator.addtive;

public class Mocha extends Syrup {

    public Mocha() {
        super("모카");
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
