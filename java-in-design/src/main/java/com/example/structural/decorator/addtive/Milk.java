package com.example.structural.decorator.addtive;

public class Milk extends Component {

    private final String name;

    public Milk() {
        this.name = "우유";
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
