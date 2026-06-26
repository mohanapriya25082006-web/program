import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Registration Form ===");

        //  Get Student Name
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        //  Get and Validate Student Age with try-catch
        int age = 0;
        boolean validAge = false;

        while (!validAge) {
            try {
                System.out.print("Enter Student Age (Numbers only): ");
                age = scanner.nextInt(); 
                
                // Validate if age is logical
                if (age < 0) {
                    throw new IllegalArgumentException("Age cannot be negative.");
                }
                
                validAge = Boolean.TRUE; // If no exception, age is valid

            } catch (InputMismatchException e) {
                // Triggered if user enters letters/symbols instead of an integer
                System.err.println("Error: Please enter a valid numeric value for Age.");
                scanner.next(); // Clear the invalid input from the Scanner buffer
            } catch (IllegalArgumentException e) {
                // Triggered if age is negative
                System.err.println("Error: " + e.getMessage());
            }
        }

        //  Output Registration Summary
        System.out.println("\nRegistration Successful!");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age:  " + age);

        scanner.close();
    }
}

