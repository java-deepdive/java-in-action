package com.example.structural.decorator.addtive;

public class Hazelnut extends Component {

    private final String name;

    public Hazelnut() {
        this.name = "헤이즐넛";
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
