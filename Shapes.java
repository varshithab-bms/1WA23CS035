import java.util.Scanner;

abstract class Shape {
    int dim1;
    int dim2;

    
    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    
    abstract void printArea();
}

class Rectangle extends Shape {
    
    Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    void printArea() {
        int area = dim1 * dim2; 
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        double area = 0.5 * dim1 * dim2; 
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    
    Circle(int radius) {
        super(radius, 0); 
    }

    @Override
    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}

public class Shapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter length and width for Rectangle:");
        int length = sc.nextInt();
        int width = sc.nextInt();
        Rectangle a1 = new Rectangle(length, width);
        a1.printArea();

        
        System.out.println("Enter base and height for Triangle:");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Triangle a2 = new Triangle(base, height);
        a2.printArea();

        
        System.out.println("Enter radius for Circle:");
        int radius = sc.nextInt();
        Circle a3 = new Circle(radius);
        a3.printArea();
    }
}
