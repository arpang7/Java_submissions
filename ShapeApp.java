package lab.assignments;

abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    double calculateArea() {
        return length * width;
    }
}

public class ShapeApp {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle radius: 5.0");
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println();
        System.out.println("Rectangle length: 4.0, width: 6.0");
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}