package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    if (line.substring(0, 8).trim().equals(args[1])) {
                        if ("-u".equals(args[0])) {
                            list.add(String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                        }
                        //если "-d"  - строка пропускается
                    } else {
                        list.add(line);
                    }
                }
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        fos.write((String.format("%s%n", s)).getBytes());
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}