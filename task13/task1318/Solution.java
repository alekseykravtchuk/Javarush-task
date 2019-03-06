package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream inStream = new FileInputStream(fileName);
        while (inStream.available() > 0)
        {
            int data = inStream.read();
            System.out.print(( char) data);
        }
        inStream.close();
        rd.close();
    }
}