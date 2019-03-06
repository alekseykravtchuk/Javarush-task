package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            FileInputStream fstream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            while (true) {
                String s = reader.readLine();
                if (s != null)lines.add(s);
                else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
