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

            StringBuilder sb = new StringBuilder();
            while (fis.available() > 0) {
                sb.append(fis.read());
            }
            String line = sb.toString();

            String [] numbers = " ".split(line);

            for (String numb : numbers) {
                double d = Double.parseDouble(numb);
                fos.write((Math.round(d) + " ").getBytes());
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
