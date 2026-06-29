//===========================
// Functional Interface
//===========================
@FunctionalInterface
interface InterestCalculator {
    double calculate(double amount);

    default void completed() {
        System.out.println("Interest Calculation Completed.");
    }
}

//===========================
// Base Interface
//===========================
interface Bank {

    void deposit(double amount);

    void withdraw(double amount);

    default void bankName() {
        System.out.println("Bank : National Bank");
    }

    static void rules() {
        System.out.println("Follow RBI Banking Rules");
    }
}

//===========================
// Customer Interface
//===========================
interface Customer {

    void customerDetails();

    default void verifyKYC() {
        System.out.println("KYC Verified Successfully");
    }
}

//===========================
// Loan Interface
//===========================
interface Loan {

    void applyLoan(double amount);

    default void loanStatus() {
        System.out.println("Loan Processing...");
    }
}

//===========================
// Transaction Interface
//===========================
interface Transaction {

    void transfer(double amount);

    default void transactionHistory() {
        System.out.println("Displaying Transaction History");
    }
}

//===========================
// Savings Account
//===========================
class SavingsAccount implements Bank, Customer, Loan, Transaction {

    private int accountNo;
    private String customerName;
    private double balance;

    public SavingsAccount(int accountNo, String customerName, double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited : " + amount);
    }

    @Override
    public void withdraw(double amount) {

        if(amount > balance)
            System.out.println("Insufficient Balance");
        else {
            balance -= amount;
            System.out.println("Withdrawn : " + amount);
        }
    }

    @Override
    public void customerDetails() {

        System.out.println("Account No : " + accountNo);
        System.out.println("Customer : " + customerName);
        System.out.println("Balance : " + balance);
    }

    @Override
    public void applyLoan(double amount) {
        System.out.println("Loan Applied : " + amount);
    }

    @Override
    public void transfer(double amount) {

        if(amount <= balance) {
            balance -= amount;
            System.out.println("Transferred : " + amount);
        }
        else {
            System.out.println("Transfer Failed");
        }
    }

    public double getBalance() {
        return balance;
    }
}

//===========================
// Main Class
//===========================
public class Business {

    public static void main(String[] args) {

        Bank.rules();

        SavingsAccount account =
                new SavingsAccount(1001,"John",50000);

        account.bankName();

        account.customerDetails();

        account.verifyKYC();

        System.out.println();

        account.deposit(10000);

        account.withdraw(7000);

        account.transfer(5000);

        account.transactionHistory();

        System.out.println();

        account.applyLoan(300000);

        account.loanStatus();

        System.out.println();

        InterestCalculator interest =
                amount -> amount * 0.08;

        double interestAmount =
                interest.calculate(account.getBalance());

        System.out.println("Interest : " + interestAmount);

        interest.completed();

        System.out.println();

        try {

            double minBalance = 1000;

            if(account.getBalance() < minBalance)
                throw new Exception("Minimum Balance Not Maintained");

            System.out.println("Account is Active");

        }
        catch(Exception e) {

            System.out.println(e.getMessage());

        }
        finally {

            System.out.println("Bank Transaction Completed");

        }
    }
}