package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        int [] byteCount = new int[256];
        while (fis.available() > 0) {
            int nextByte = fis.read();
            byteCount[nextByte]++;
        }
        int minValue = 2147483647;
        for (int i = 0; i < 256; i++) {
            if(byteCount[i] < minValue && byteCount[i] > 0) { minValue = byteCount[i]; }
        }

        for (int i = 0; i < 256; i++) {
            if(byteCount[i] == minValue) {
                System.out.print(i + " ");
            }
        }
        fis.close();
    }
}
