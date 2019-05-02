package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            int id = Integer.parseInt(args[0]);
            String line;
            do {
                line = br.readLine();
            }
            while (!line.startsWith(args[0] + ' '));
            System.out.println(line);
            br.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
