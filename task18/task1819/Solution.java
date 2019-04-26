package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        try {
            FileInputStream fileInputStream1 = new FileInputStream(file1);

            byte [] buffer = new byte[fileInputStream1.available()];
            fileInputStream1.read(buffer);

            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2, 200);
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
            fileOutputStream.write(buffer);

            fileInputStream1.close();
            fileInputStream2.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
