import java.util.Scanner;

public class FibonacciTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int a = 0, b = 1, c;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");

                c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }

        sc.close();
    }
}