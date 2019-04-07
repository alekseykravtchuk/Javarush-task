package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner scanner = new Scanner(System.in);
        try {
            FileInputStream inputStream = new FileInputStream(scanner.nextLine());
            while (inputStream.available() >= 1000) {
                inputStream = new FileInputStream(scanner.nextLine());
            }
            inputStream.close();
            throw new DownloadException();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }

    }

    public static class DownloadException extends Exception {

    }
}
