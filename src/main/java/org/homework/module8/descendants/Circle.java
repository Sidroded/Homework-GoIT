package org.homework.module8.descendants;

import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

public class Circle extends Shape {
    private final double radius;

    public Circle(String name, Color color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getSquare() {
        return PI * Math.pow(radius, 2);
    }
}
