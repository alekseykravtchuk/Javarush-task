package com.javarush.task.task18.task1825;

/*
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String finalFile = ".part".split(s)[0];
        FileOutputStream fos = new FileOutputStream(finalFile, true);
        ArrayList <String> names = new ArrayList<>();
        String [] inputFiles = s.split(", ");
        while (true) {
            String file = "";
            for (int i = 0; i < inputFiles.length; i++) {
                file = inputFiles[i];
                if (file.equals("end")) break;
                names.add(inputFiles[i]);
            }
            if (file.equals("end")) break;
            s = bufferedReader.readLine();
            inputFiles = s.split(", ");
        }
        Collections.sort(names);
        for (String file : names) {
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1000];
            while (fis.available() > 0) {
                int count = fis.read(buffer);
                fos.write(buffer, 0, count);
            }
            fis.close();
        }

        fos.close();


    }
}
