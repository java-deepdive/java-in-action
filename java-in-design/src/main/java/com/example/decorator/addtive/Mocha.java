package com.example.decorator.addtive;

public class Mocha extends Component {

    private final String name;

    public Mocha() {
        this.name = "모카";
    }

    @Override
    public double cost() {
        return 500;
    }

    @Override
    public String toString() {
        return name;
    }
}
