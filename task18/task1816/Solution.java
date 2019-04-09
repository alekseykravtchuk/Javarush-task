package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int counter = 0;
        while (fis.available()> 0) {
            int nextByte = fis.read();
            if ((nextByte >= 65 && nextByte <= 90) || (nextByte >= 97 && nextByte <= 122)) counter++;
        }
        System.out.println(counter);
        fis.close();
    }
}
