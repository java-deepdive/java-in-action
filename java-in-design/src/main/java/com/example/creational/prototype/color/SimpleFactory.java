package com.example.creational.prototype.color;

public class SimpleFactory {

    public static Color makeBlack() {
        return new BlackColor();
    }

    public static Color makeBlue() {
        return new BlueColor();
    }
}
