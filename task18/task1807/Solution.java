package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        int count = 0;
        while (fis.available() > 0) {
            int nexByte = fis.read();
            if (',' == (char) nexByte) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
        fis.close();

    }
}
