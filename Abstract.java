// ==========================================
// ABSTRACT CLASS
// ==========================================
abstract class Shape { 
    private String name; 

    public Shape(String name) { 
        setName(name); // Fixed case sensitivity issue from 'setname' to 'setName'
    } 

    public void setName(String name) { 
        this.name = name; 
    } 

    public String getName() { 
        return name; 
    } 

    // Abstract methods to be overridden by subclasses
    public abstract double getArea(); 
    public abstract double getPerim(); 
}

// ==========================================
// CONCRETE SUBCLASSES
// ==========================================
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerim() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerim() {
        return 2 * (width + height);
    }
}

public class Abstract {
    public static void main(String[] args) {
        // Create an array utilizing polymorphic references
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle("My Circle", 5.0);
        shapes[1] = new Rectangle("My Rectangle", 4.0, 6.0);

        // Iterate through each shape and display execution results
        for (Shape shape : shapes) {
            System.out.println("Shape Name: " + shape.getName());
            System.out.printf("Area: %.2f%n", shape.getArea());
            System.out.printf("Perimeter: %.2f%n", shape.getPerim());
            System.out.println("--------------------");
        }
    }
}

