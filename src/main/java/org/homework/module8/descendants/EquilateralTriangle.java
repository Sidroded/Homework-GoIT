package org.homework.module8.descendants;

import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

public class EquilateralTriangle extends Shape {
    private final double sideLength;

    public EquilateralTriangle(String name, Color color, double sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getSquare() {
        return (Math.pow(sideLength, 2) * Math.sqrt(3)) / 4;
    }
}
