
import java.util.Scanner;

abstract class Account 
{
    String customerName;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountNumber, double initialBalance)  {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
}

    abstract void deposit(double amount);
    abstract void checkBalance();
    abstract void withdraw(double amount);
}


class SavingsAccount extends Account 
{
   double interestRate;

public SavingsAccount(String customerName, String accountNumber, double initialBalance, double interestRate) 
{
        super(customerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
   }


    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest Computed and Deposited: " + interest);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } 
	else {
            System.out.println("Insufficient balance!");
        }
    }
}

class CurrentAccount extends Account {
    private double minimumBalance;
    private double serviceCharge;

    public CurrentAccount(String customerName, String accountNumber, double initialBalance, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }


    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }


    public void checkBalance() {
        System.out.println("Current Account Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    private void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge imposed: " + serviceCharge);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank!");

        // Create a savings account
        SavingsAccount savingsAccount = new SavingsAccount("Alice", "S123", 1000.0, 5.0);
        // Create a current account
        CurrentAccount currentAccount = new CurrentAccount("Bob", "C456", 500.0, 300.0, 20.0);

        // Perform operations on Savings Account
        savingsAccount.deposit(200);
        savingsAccount.withdraw(50);
        savingsAccount.computeAndDepositInterest();
        savingsAccount.checkBalance();

        // Perform operations on Current Account
        currentAccount.deposit(100);
        currentAccount.withdraw(250);
        currentAccount.withdraw(400);  // This will trigger service charge
        currentAccount.checkBalance();

        scanner.close();
    }
}