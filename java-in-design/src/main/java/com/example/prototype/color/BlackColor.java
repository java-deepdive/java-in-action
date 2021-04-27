package com.example.prototype.color;

class BlackColor extends Color {

    public BlackColor() {
        this.colorName = "black";
    }

    // 정적 팩토리 메서드
    public static Color of() {
        return new BlackColor();
    }

    @Override
    void addColor() {
        System.out.println("Black color added");
    }
}
