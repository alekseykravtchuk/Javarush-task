package com.javarush.task.task15.task1519;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int i;
        while (!(s = scanner.nextLine()).equals("exit")) {
            try {
                if (s.contains(".")) {
                    print(Double.parseDouble(s));
                }
                else if ((i = Integer.parseInt(s)) > 0 && i < 128 ) {
                    print((short) i);
                }
                else print(i);
            }
            catch (Exception e) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
