package CinemaWeb;

import java.util.Scanner;

public class Check {
    static int getRangeInt(int leftRange, int rightRange, String message) {
        System.out.println(message);
        Scanner scn = new Scanner(System.in);
        int value;
        if (scn.hasNextInt()) {
            value = scn.nextInt();
            if (value < leftRange || value > rightRange) {
                System.out.println("Введите целое число в диапозоне от " + leftRange + " до " + rightRange);
                return getRangeInt(leftRange, rightRange, message);
            } else {
                return value;
            }

        }
        System.out.println("Введите целое число");
        System.out.println(message);
        return getRangeInt(leftRange, rightRange, message);
    }

    static int getInt(String message) {
        System.out.println(message);
        Scanner scn = new Scanner(System.in);
        int value;
        if (scn.hasNextInt()) {
            value = scn.nextInt();
            return value;
        }
        System.out.println("Введите целое число");
        System.out.println(message);
        return getInt(message);
    }

    static String getString(String message) {
        System.out.println(message);
        Scanner scn = new Scanner(System.in);
        String newString;
        if (scn.hasNextLine()) {
            newString = scn.nextLine();
            return newString;
        }
        System.out.println("Введите строку");
        System.out.println(message);
        return getString(message);
    }
}
