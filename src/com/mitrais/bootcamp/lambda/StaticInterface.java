/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

/**
 *
 * @author Aditia_RS458
 */
interface Shape {

    double getArea();

    static double sumAreas(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) {
            sum += s.getArea();
        }
        return sum;
    }
}

class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }
    
}

class Rectangular implements Shape {

    private double length, width;

    public Rectangular(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class Square implements Shape {

    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }
}

public class StaticInterface {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5),
            new Rectangular(6, 3),
            new Square(4)};
        
        System.out.println("Sum of areas : "+Shape.sumAreas(shapes));
    }

}
