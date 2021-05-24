package com.example.creational.prototype.color;

class BlueColor extends Color {
    public BlueColor() {
        this.colorName = "blue";
    }

    @Override
    void addColor() {
        System.out.println("Blue color added");
    }

}
