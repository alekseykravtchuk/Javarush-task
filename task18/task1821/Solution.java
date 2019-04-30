package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
       try {
            FileInputStream fis = new FileInputStream(args[0]);

            int [] counts = new int[255];
            while (fis.available() > 0) {
                counts[fis.read()]++;
            }

            for (int i = 0; i < 127; i++) {
                if (counts[i] != 0) {
                    System.out.println((char) i + " " + counts[i]);
                }
            }


            fis.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
