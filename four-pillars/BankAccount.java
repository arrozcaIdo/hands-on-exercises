import java.util.*;
// ENCAPSULATION

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // getters and setters
    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public double getBalance(){
        return balance;
    }

    // for negative input
    public void setBalance(double balance){
        if(balance < 0){
            System.out.println("Error: Balance cannot be negative.");
            return;
        }
        this.balance = balance;
    }

    // methods
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Successfully Deposited $" + amount);
        } else{
            System.out.println("Error: Invalid deposit amount.");
        }
    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Error: Invalid withdrawal amount.");
        } else if(amount > balance){
            System.out.println("Error: Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn $" + amount);
        }

    }

    public void displayAccountInfo() {
        System.out.println("\n---Account Information---");
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Current Balance: " + getBalance() + "\n");
    }

    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     BankAccount account = new BankAccount();

     System.out.print("Enter account holder name: ");
     account.setAccountHolder(sc.nextLine());

     System.out.print("Enter account number: ");
     account.setAccountNumber(sc.nextLine());

    System.out.print("Enter initial balance: ");
    account.setBalance(sc.nextDouble());

    account.displayAccountInfo();

    System.out.print("Enter amount to deposit: ");
    double amount = sc.nextDouble();
    account.deposit(amount);

    System.out.print("Enter amount to withdraw: ");
    amount = sc.nextDouble();
    account.withdraw(amount);

    account.displayAccountInfo();

    }
}
