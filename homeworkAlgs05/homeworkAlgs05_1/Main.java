package homeworkAlgs05_1;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите число:");
        int number = scanner.nextInt();
        System.out.println("Введите степень:");
        int exp = scanner.nextInt();
        System.out.println(Exponentiation.exponentiation(number, exp));
    }
}
