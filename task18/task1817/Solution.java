package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int countSymbol = fis.available();
        int countSpace = 0;
        while (fis.available() > 0) {
            int nextByte = fis.read();
            if (nextByte == ' ') {
                countSpace++;
            }
        }
        fis.close();
        double compare = (double) countSpace / countSymbol * 100;
        System.out.printf("%.2f", compare);
    }
}
