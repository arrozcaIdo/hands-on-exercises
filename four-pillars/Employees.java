import java.util.*;
// ABSTRACTION

// abstract class
abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
    public abstract void displayInfo();

    public void companyPolicy() {
        System.out.println("Company Policy: All employees must submit attendance before payroll processing.");
    }
}

class FullTimeEmployee extends Employee {
    private final double dailyRate;
    private final int daysWorked;

    public FullTimeEmployee(String name, double dailyRate, int daysWorked) {
        super(name);
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    @Override
    public double calculateSalary() {
        return dailyRate * daysWorked;
    }

    @Override
    public void displayInfo() {
        System.out.println("Salary: PHP" + calculateSalary());
        companyPolicy();
    }
}

class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayInfo() {
        System.out.println("Salary: PHP" + calculateSalary());
        companyPolicy();
    }
}

// Main class
public class Employees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee employee = null;

            System.out.print("Enter employee type: ");
            String type = sc.nextLine();

            if (type.equalsIgnoreCase("Full-Time")) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter daily rate: ");
                double dailyRate = sc.nextDouble();
                System.out.print("Enter days worked: ");
                int daysWorked = sc.nextInt();
                sc.nextLine(); // clear buffer

                employee = new FullTimeEmployee(name, dailyRate, daysWorked);

            } else if (type.equalsIgnoreCase("Part-Time")) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter hourly rate: ");
                double hourlyRate = sc.nextDouble();
                System.out.print("Enter hours worked: ");
                int hoursWorked = sc.nextInt();
                sc.nextLine(); // clear buffer

                employee = new PartTimeEmployee(name, hourlyRate, hoursWorked);

            } else {
                System.out.println("Error: Invalid employee type.");
            }

        // for NullPointerException
        if(employee != null) {
            employee.displayInfo();
        }

        sc.close();
    }
}
