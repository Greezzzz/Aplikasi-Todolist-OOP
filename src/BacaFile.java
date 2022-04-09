import java.io.BufferedReader;
import java.io.FileReader;

public class BacaFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/README.md"))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Throwable throwable) {
            System.out.println("Gagal membaca file : " + throwable.getMessage());
        }
    }
}
