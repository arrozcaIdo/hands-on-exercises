import java.util.*;
// INHERITANCE

// parent class
class Vehicle{
    protected String brand, model;
    protected int year;

    public Vehicle(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayDetails(){
        System.out.println("\n---Vehicle Details---");
        System.out.print("Brand: " + brand + " | Model: " + model + " | Year: " + year);
    }
}

// child
class Car extends Vehicle{
    private final int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors){
        super(brand,model,year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.print("| Doors: " + numberOfDoors);
    }
}

// child
class Motorcycle extends Vehicle{
    private final String engineType;

    public Motorcycle(String brand, String model, int year, String engineType){
        super(brand,model,year);
        this.engineType = engineType;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println(" | Engine Type: " + engineType);
    }
}

// main
public class Vehicles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Vehicle vehicle = null;   // no obj yet

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        System.out.print("Enter brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter model: ");
        String model = sc.nextLine();

        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();

        if(type.equalsIgnoreCase("Car")){
            System.out.print("Enter number of doors: ");
            int doors = sc.nextInt();
            vehicle = new Car(brand, model, year, doors);

        } else if (type.equalsIgnoreCase("Motorcycle")){
            System.out.print("Enter engine type: ");
            String engineType = sc.nextLine();
            vehicle = new Motorcycle(brand, model, year, engineType);
        } else {
            System.out.println("Error: Invalid vehicle type.");
        }

        // to counter NullPointerException
        if(vehicle != null) {
            vehicle.displayDetails();
        }

        sc.close();
    }
}