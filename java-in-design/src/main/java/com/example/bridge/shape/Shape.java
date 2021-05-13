package com.example.bridge.shape;

public abstract class Shape {

    protected Color color;

    Shape(Color color) {
        this.color = color;
    }

    protected abstract String draw();
}
