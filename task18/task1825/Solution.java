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
        String finalFile = ".part".split(s)[0]; //валик принимает только  s.split(".part)[0];
        FileOutputStream fos = new FileOutputStream(finalFile, true); //true, чтобы файл дописывался, а не переписывался
        ArrayList <String> names = new ArrayList<>(); //список с именами файлов
        String [] inputFiles = s.split(", "); //разбиваем строку на имена файлов, и возможный 'end'
        while (true) { //работает пока не встретим 'end'
            String file = "";
            for (int i = 0; i < inputFiles.length; i++) {
                file = inputFiles[i];
                if (file.equals("end")) break; //выходим, если 'end'
                names.add(inputFiles[i]); //добавляем в спивок имя файла
            }
            if (file.equals("end")) break; //выходим, если 'end'
            s = bufferedReader.readLine(); //читаем дальше строки
            inputFiles = s.split(", "); //снова разбиваем строку на имена файлов, и возможный 'end'
        }
        Collections.sort(names); //сортируем попорядку
        for (String file : names) {
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1000]; //создаем буффер
            while (fis.available() > 0) {
                int count = fis.read(buffer); //узнаем количество байт, если их меньше 1000
                fos.write(buffer, 0, count); //записывает их буффера по 1000 байт
            }
            fis.close();
        }

        fos.close();


    }
}
