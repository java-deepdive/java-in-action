package com.example.behavioral.visitors.visitor;

import com.example.behavioral.visitors.shapes.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitorTest {

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }

    @DisplayName("방문자 패턴 도형에 대한 기하학적 모양을 XML로 만들기 테스트")
    @Test
    void testCase1() {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);

    }
}
