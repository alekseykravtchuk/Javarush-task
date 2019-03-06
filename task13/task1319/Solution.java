package com.javarush.task.task13.task1319;

import java.io.*;

import static java.lang.System.out;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while (true) {
             String line = bufferedReader.readLine();
             bufferedWriter.write(line + "\r\n");
             if (line.equals("exit")) break;
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
