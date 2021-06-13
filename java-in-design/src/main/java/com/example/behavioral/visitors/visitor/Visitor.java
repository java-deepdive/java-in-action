package com.example.behavioral.visitors.visitor;

import com.example.behavioral.visitors.shapes.Circle;
import com.example.behavioral.visitors.shapes.CompoundShape;
import com.example.behavioral.visitors.shapes.Dot;
import com.example.behavioral.visitors.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
