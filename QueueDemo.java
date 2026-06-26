import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class QueueDemo {

    public static void main(String[] args) {

        java.util.Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   JAVA QUEUE PROGRAM (LINKEDLIST COLL.)   ");
        System.out.println("===========================================");

        while (true) {
            System.out.println("\n--- Available Options ---");
            System.out.println("1. Enqueue / Add Element (add)");
            System.out.println("2. Enqueue / Offer Element (offer)");
            System.out.println("3. Dequeue / Remove Head (remove)");
            System.out.println("4. Dequeue / Poll Head (poll)");
            System.out.println("5. Peek Head / Strict (element)");
            System.out.println("6. Peek Head / Safe (peek)");
            System.out.println("7. Check Size");
            System.out.println("8. Check If Empty");
            System.out.println("9. Clear Queue");
            System.out.println("10. Display Queue");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter integer to add: ");
                    try {
                        int val = Integer.parseInt(scanner.nextLine());
                        queue.add(val);
                        System.out.println(val + " added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer!");
                    }
                    break;

                case 2:
                    System.out.print("Enter integer to offer: ");
                    try {
                        int val = Integer.parseInt(scanner.nextLine());
                        if (queue.offer(val)) {
                            System.out.println(val + " offered successfully.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer!");
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Removed: " + queue.remove());
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;

                case 4:
                    Integer pollVal = queue.poll();
                    if (pollVal == null) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Polled: " + pollVal);
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Front Element: " + queue.element());
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;

                case 6:
                    Integer peekVal = queue.peek();
                    if (peekVal == null) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Front Element: " + peekVal);
                    }
                    break;

                case 7:
                    System.out.println("Queue Size: " + queue.size());
                    break;

                case 8:
                    System.out.println("Is Queue Empty? " + queue.isEmpty());
                    break;

                case 9:
                    queue.clear();
                    System.out.println("Queue cleared successfully.");
                    break;

                case 10:
                    System.out.println("Queue: " + queue);
                    break;

                case 11:
                    System.out.println("Program terminated.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

