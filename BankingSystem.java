//  Define a Custom Exception for Banking Errors
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

//  Define the BankAccount Class
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit Method with Validation
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Successfully deposited: Rs" + amount);
    }

    // Withdraw Method that throws our Custom Exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            // Throwing exception if balance is too low
            throw new InsufficientFundsException("Decline! Tried to withdraw Rs" + amount + " but balance is only Rs" + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew: Rs" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

// 3. Main Class to Execute and Handle Try-Catch Flow
public class BankingSystem {
    public static void main(String[] args) {
        // Create an account with a Rs500 initial balance
        BankAccount account = new BankAccount("SAV-101", 500.00);
        System.out.println("Initial Balance: Rs" + account.getBalance());
        System.out.println("----------------------------------------");

        // Scenario A: Successful Transaction
        try {
            System.out.println("Attempting to withdraw Rs200...");
            account.withdraw(200.00); // This succeeds
            System.out.println("Current Balance: Rs" + account.getBalance());
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        System.out.println("----------------------------------------");

        // Scenario B: Failed Transaction (Throws InsufficientFundsException)
        try {
            System.out.println("Attempting to withdraw Rs400...");
            account.withdraw(400.00); // Throws exception (Rs300 remaining)
            System.out.println("This line will be skipped due to the error.");
        } catch (InsufficientFundsException e) {
            // Catches our custom exception
            System.out.println("Error Caught: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Multi-catch block setup for safety
            System.out.println("Runtime Error: " + e.getMessage());
        } finally {
            // The finally block runs regardless of whether an exception occurs
            System.out.println("Finally Block: Syncing transaction logs with the central database...");
        }

        System.out.println("----------------------------------------");
        System.out.println("Final Account Balance: Rs" + account.getBalance());
        System.out.println("Application Flow Continues... System is Online.");
    }
}

