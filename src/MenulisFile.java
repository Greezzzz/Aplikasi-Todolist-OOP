import java.io.FileWriter;
import java.io.IOException;

public class MenulisFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("src/Data/History.txt");
            writer.write("Hello");
            writer.close();
            System.out.println("Berhasil menulis file");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
