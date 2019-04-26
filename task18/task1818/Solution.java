package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner =  new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        try {
            FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file1, true);
            FileInputStream fileInputStream1 = new FileInputStream(file2);
            FileInputStream fileInputStream2 = new FileInputStream(file3);

            while (fileInputStream1.available() > 0) {
                int input = fileInputStream1.read();
                fileOutputStream1.write(input);
            }

            while (fileInputStream2.available() > 0) {
                int input = fileInputStream2.read();
                fileOutputStream2.write(input);
            }
            fileInputStream1.close();
            fileInputStream2.close();
            fileOutputStream1.close();
            fileOutputStream2.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
