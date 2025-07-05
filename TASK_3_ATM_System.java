package CODESOFT;
import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful. Amount: ₹" + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance. Available: ₹" + balance);
        } else if (amount <= 0) {
            System.out.println("⚠️ Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful. Amount: ₹" + amount);
        }
    }
}

// Class to represent the ATM interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🏦 Welcome to the ATM Machine");

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n📋 Select an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter choice (1-4): ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("❗ Please enter a number (1-4): ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void checkBalance() {
        System.out.println("💰 Your current balance is: ₹" + account.getBalance());
    }

    private void makeDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void makeWithdrawal() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main class to run the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        // Initialize with some balance
        BankAccount userAccount = new BankAccount(5000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

