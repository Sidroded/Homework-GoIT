package org.homework.module8;

import org.homework.module8.descendants.*;
import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class TestShape {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Shape square = new Square("TestSquare", Color.BLACK, 4);
        Shape circle = new Circle("TextCircle", Color.RED, 3);
        Shape rectangle = new Rectangle("TestRectangle", Color.GREEN, 2,4);
        Shape rhombus = new Rhombus("TextRhombus", Color.WHITE, 2,5);
        EquilateralTriangle triangle = new EquilateralTriangle("TextTriangle", Color.PINK, 4);

        shapes.add(square);
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(rhombus);
        shapes.add(triangle);

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println(shape.getName());
        }
    }
}