package com.example.structural.bridge.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    void testCase() {
        //a square with red color
        Shape square = new Square(new Red());

        assertEquals(square.draw(), "Square drawn. Color is Red");
    }
}
