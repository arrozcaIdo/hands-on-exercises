import java.util.*;
// POLYMORPHISM

// parent class
class Shape{
    public double calculateArea(){
        return 0; // to be overridden
    }
}

class Circle extends Shape{
    private final double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private final double width, height;

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
    private final double base, height;

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

        // array
        Shape[] shapes = new Shape[3];

        for(int i = 0; i < 3; i++){
            System.out.print("Enter shape type: ");
            String type = sc.nextLine();

            if(type.equalsIgnoreCase("Circle")){
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                sc.nextLine();
                shapes[i] = new Circle(radius);
                System.out.printf("Area of Circle: %.2f\n\n", shapes[i].calculateArea());

            } else if(type.equalsIgnoreCase("Rectangle")){
                System.out.print("Enter width: ");
                double width = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                sc.nextLine();
                shapes[i] = new Rectangle(width, height);
                System.out.printf("Area of Rectangle: %.0f\n\n", shapes[i].calculateArea());

            } else if(type.equalsIgnoreCase("Triangle")){
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                sc.nextLine();
                shapes[i] = new Triangle(base, height);
                System.out.printf("Area of Triangle: %.0f\n\n", shapes[i].calculateArea());

            } else {
                System.out.println("Error: Invalid shape.");
                i--; // try again
            }
        }

        sc.close();
    }
}