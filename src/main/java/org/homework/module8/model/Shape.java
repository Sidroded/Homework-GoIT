package org.homework.module8.model;

import java.util.Objects;

public abstract class Shape implements AreaCalculation {
    private final String name;
    private final Color color;

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Shape(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public abstract double getSquare();

    @Override
    public String toString() {
        return "Shape: " + getClass().getSimpleName() + ", name: " + getName() + ", color: " + getColor().toString() + ", square is: " + getSquare();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, this.getSquare());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shape.getName().equals(name) && shape.getColor().equals(color) && shape.getSquare() == this.getSquare();
    }
}
