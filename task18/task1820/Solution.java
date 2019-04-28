package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        try {
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            String line = "";
            while (fis.available() > 0) {
                line += (char) fis.read();
            }

            String [] numbers = line.split(" ");

            for (int i = 0; i < numbers.length; i ++) {
                double d = Double.parseDouble(numbers[i]);
                fos.write((Math.round(d) + " ").getBytes());
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
