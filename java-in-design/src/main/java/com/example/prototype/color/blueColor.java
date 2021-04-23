package com.example.prototype.color;

class blueColor extends Color {
    public blueColor() {
        this.colorName = "blue";
    }

    @Override
    void addColor() {
        System.out.println("Blue color added");
    }

}
