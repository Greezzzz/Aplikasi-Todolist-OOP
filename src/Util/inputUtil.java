package Util;

import java.util.Scanner;

public class inputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + ": ");
        String dataInput = scanner.nextLine();
        return dataInput;
    }
}
