import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class BankAccount {
    private int pin;
    private double balance;
    private ArrayList<Transaction> history = new ArrayList<>();

    BankAccount(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add(new Transaction("Withdraw", amount));
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : history) {
            System.out.println(t.type + " : " + t.amount);
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample account
        BankAccount account = new BankAccount(1234, 5000);

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!account.validatePin(pin)) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 4:
                    account.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}