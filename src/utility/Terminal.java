package utility;

import java.util.Random;
import java.util.Scanner;

public class Terminal {

    private final static int UPPER_LIMIT = 2;
    private final static int LOWER_LIMIT = 0;

    private Terminal(){

    }

    public static int generateRandomNumber() {

        Random randomNumber = new Random();
        return randomNumber.nextInt(UPPER_LIMIT - LOWER_LIMIT);
    }

    public static String inputString() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static  String inputString(String message) {

        System.out.println(message);
        return inputString();
    }

    public static double inputNumber() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static double inputNumber(String message) {

        System.out.println(message);
        return inputNumber();
    }
}
