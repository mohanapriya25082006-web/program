import java.io.FileWriter;
import java.io.IOException;

public class AppendFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sample.txt", true);
            writer.write("\nThis line is appended.");
            writer.close();

            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}