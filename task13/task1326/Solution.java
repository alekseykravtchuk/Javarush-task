package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            inputStream = new FileInputStream(reader.readLine());
            Scanner scanner = new Scanner(inputStream);
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt())
                numbers.add(scanner.nextInt());
            Collections.sort(numbers);
            for (int n : numbers){
                if (n % 2 == 0) System.out.println(n);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            inputStream.close();
        }


    }
}
