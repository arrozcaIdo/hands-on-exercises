import java.util.*;

class Shape{
    public double calculateArea(){
        return 0; // to be overridden
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double width, height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return width * height;
    }
}

class Triangle extends Shape{
    private double base, height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return 0.5 * base * height;
    }
}

public class Shapes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Shape[] shapes = new Shape[3];

        System.out.print("Enter radius: ")
        shapes[0] = new Circle(radius);
    }
}
