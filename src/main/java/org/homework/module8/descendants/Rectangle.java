package org.homework.module8.descendants;

import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

import java.util.Objects;

public class Rectangle extends Shape {
    private final double sideA;
    private final double sideB;

    public Rectangle(String name, Color color, double sideA, double sideB) {
        super(name, color);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public double getSquare() {
        return sideA * sideB;
    }

    /*
       Правильно ли я переписал метод hashCode() относительно класса родителя?
    */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getSquare(), sideA, sideB);
    }

    /*
        Поскольку при разных сторонах/диагоналях может быть одинаковая площадь пришлось переопределить метод
        equals() класса родителя.
     */
    @Override
    public boolean equals(Object o) {
        Rectangle rectangle = (Rectangle) o;
        if (rectangle.getSideA() != sideA || rectangle.getSideB() != sideB) return false;
        return super.equals(o);
    }
}
