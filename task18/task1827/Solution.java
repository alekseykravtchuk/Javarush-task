package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        if ((args.length==4) && (args[0].equals("-c"))) {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int id;
            int max = 0;
            while (reader.ready()) {
                id = Integer.parseInt(reader.readLine().substring(0,8).trim());
                if (id > max) max = id;
            }
            reader.close();

            writer.newLine();
            writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s",max+1,args[1],args[2],args[3]));
            writer.close();
        }
    }
}
