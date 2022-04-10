import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Base64;

public class BacaFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/History.txt"))) {
            int i = 0;
            while (true) {
                i++;
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(i + ". " + decode(line));
            }
        } catch (Throwable throwable) {
            System.out.println("Gagal membaca file : " + throwable.getMessage());
        }
    }

    public static String decode(String decode) {
        byte[] bytes = Base64.getDecoder().decode(decode);
        String result = new String(bytes);
        return result;
    }
}
