package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class Problem 1: Shape Area Calculator
 * Demonstrates the concept of Abstract Classes and Polymorphism in Java.
 */
public class ShapeAreaCalculator {

    public static abstract class Shape {
        protected String name;

        public Shape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateArea();
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            super("Rectangle");
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Shape Area Calculator ---");

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.printf(Locale.US, "%s Area: %.2f%n", circle.getName(), circle.calculateArea());
        System.out.printf(Locale.US, "%s Area: %.2f%n", rectangle.getName(), rectangle.calculateArea());

        scanner.close();
    }
}

