import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void display() {
        System.out.println("----------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}

public class BankManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();
        sc.nextLine();

        if (findAccount(number) != null) {
            System.out.println("Account already exists.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double deposit = sc.nextDouble();

        accounts.add(new BankAccount(number, name, deposit));
        System.out.println("Account created successfully.");
    }

    public static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        BankAccount account = findAccount(number);

        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        BankAccount account = findAccount(number);

        if (account != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void transferMoney() {
        System.out.print("From Account: ");
        int from = sc.nextInt();

        System.out.print("To Account: ");
        int to = sc.nextInt();

        BankAccount sender = findAccount(from);
        BankAccount receiver = findAccount(to);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0 && sender.getBalance() >= amount) {
            sender.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer completed.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        BankAccount account = findAccount(number);

        if (account != null) {
            account.display();
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            account.display();
        }
    }

    public static void menu() {
        System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Check Balance");
        System.out.println("6. Display All Accounts");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {

        while (true) {

            menu();

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    transferMoney();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    displayAllAccounts();
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
