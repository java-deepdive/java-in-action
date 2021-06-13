package com.example.behavioral.visitors.shapes;

import com.example.behavioral.visitors.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
