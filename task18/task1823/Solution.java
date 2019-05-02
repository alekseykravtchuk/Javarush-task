package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        while (!fileName.equals("exit")) {
            ReadThread rt = new ReadThread(fileName);
            rt.start();
            fileName = br.readLine();
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private ArrayList<Integer> list = new ArrayList<>();
        public ReadThread(String fileName){
            this.fileName = fileName;
        }

        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0) {
                    list.add(fis.read());
                }
                int element = list.get(0);
                for (Integer x : list) {
                    if (Collections.frequency(list, x) > Collections.frequency(list, element))
                        element = x;
                }
                resultMap.put(fileName, element);

                fis.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
