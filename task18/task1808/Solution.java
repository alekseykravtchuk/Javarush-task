package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);
        int fileSize = inputStream.available();
        while (inputStream.available() > fileSize / 2) {
            outputStream1.write(inputStream.read());
        }

        while (inputStream.available() > 0) {
            outputStream2.write(inputStream.read());
        }

        scanner.close();
        outputStream1.close();
        inputStream.close();
        outputStream2.close();
    }
}
