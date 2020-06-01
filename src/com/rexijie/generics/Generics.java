package com.rexijie.generics;
interface Shape {
     double perimeter();
}

class Square implements Shape {
    private final double l1;
    private final double l2;
    private final double l3;
    private final double l4;

    public Square(double l1) {
        this.l1 = l1;
        this.l2 = l1;
        this.l3 = l1;
        this.l4 = l1;
    }

    @Override
    public double perimeter() {
        return l1 + l2 + l3 + l4;
    }
}
class Triangle implements Shape {
    private final double l1;
    private final double l2;
    private final double l3;

    public Triangle(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    @Override
    public double perimeter() {
        return l1 + l2 + l3;
    }
}

class ShapeService<T extends Shape> {

    public double getPerimeter(T t) {
        return t.perimeter();
    }
}
public class Generics {
    public static void main(String[] args) {
        ShapeService<Triangle> triangleService = new ShapeService<>();
        var trianglePerimeter = triangleService.getPerimeter(new Triangle(2, 3, 4));
        System.out.println(trianglePerimeter);

        ShapeService<Square> squareService = new ShapeService<>();
        var squarePerimeter = squareService.getPerimeter(new Square(2));
        System.out.println(squarePerimeter);
    }
}
