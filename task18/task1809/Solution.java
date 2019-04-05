package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        FileOutputStream outputStream = new FileOutputStream(scanner.nextLine());
        int [] line = new int[inputStream.available()];
        int index = 0;
        while (inputStream.available() > 0) {
            line[index++] = inputStream.read();
        }
        for (int i = line.length-1; i >= 0; i--) {
            outputStream.write(line[i]);
        }
        inputStream.close();
        outputStream.close();
    }
}
