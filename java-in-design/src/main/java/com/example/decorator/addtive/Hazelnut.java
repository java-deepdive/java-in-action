package com.example.decorator.addtive;

public class Hazelnut extends Component {

    protected Hazelnut() {
        super("헤이즐넛");
    }

    @Override
    public double cost() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
