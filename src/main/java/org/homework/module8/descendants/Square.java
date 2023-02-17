package org.homework.module8.descendants;

import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

public class Square extends Shape {
    private final double sideLength;

    public Square(String name, Color color, double sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getSquare() {
        return sideLength * sideLength;
    }
}
