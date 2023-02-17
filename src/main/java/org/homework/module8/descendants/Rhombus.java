package org.homework.module8.descendants;

import org.homework.module8.model.Color;
import org.homework.module8.model.Shape;

import java.util.Objects;


public class Rhombus extends Shape {
    private final double diagonalA;
    private final double diagonalB;


    public Rhombus(String name, Color color, double diagonalA, double diagonalB) {
        super(name, color);
        this.diagonalA = diagonalA;
        this.diagonalB = diagonalB;
    }

    public double getDiagonalA() {
        return diagonalA;
    }

    public double getDiagonalB() {
        return diagonalB;
    }

    @Override
    public double getSquare() {
        return diagonalA * diagonalB / 2 ;
    }

    /*
        Правильно ли я переписал метод hashCode() относительно класса родителя?
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getSquare(), diagonalA, diagonalB);
    }

    /*
        Поскольку при разных сторонах/диагоналях может быть одинаковая площадь пришлось переопределить метод
        equals() класса родителя.
     */
    @Override
    public boolean equals(Object o) {
        Rhombus rhombus = (Rhombus) o;
        if (rhombus.getDiagonalA() != diagonalA || rhombus.getDiagonalB() != diagonalB) return false;
        return super.equals(o);
    }
}
