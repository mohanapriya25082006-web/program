import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    void showBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            System.out.println(b.id + " | " + b.title + " | " + b.author +
                    " | Issued: " + b.isIssued);
        }
    }

    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned!");
                return;
            }
        }
        System.out.println("Invalid book ID!");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    lib.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    lib.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    lib.returnBook(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
