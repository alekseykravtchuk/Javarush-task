package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Scanner in = new Scanner(new File(scanner.nextLine()));
            while (in.hasNextLine()) {
                allLines.add(in.nextLine());
            }
            in = new Scanner(new File(scanner.nextLine()));
            while (in.hasNextLine()) {
                forRemoveLines.add(in.nextLine());
            }
            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        scanner.close();

        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e) {
            System.out.println(e);
        }
        finally {
            for (String s:
                 allLines) {
                System.out.println(s);
            }
        }


    }

    public void joinData() throws CorruptedDataException {
        boolean isConteins = true;
        for(int i = 0; i < forRemoveLines.size(); i++) {
                for(int j = 0; j < allLines.size(); j++) {
                    if (allLines.get(j).equals(forRemoveLines.get(i))) {
                        isConteins = true;
                        break;
                    }
                    else isConteins = false;
                }
            }


        if (isConteins) {
            Iterator<String> lineIterator = allLines.iterator(); // создаем итератор
            while (lineIterator.hasNext()) {
                String nextLine = lineIterator.next(); //читаем следующую строку в первом списке
                for (int i = 0; i < forRemoveLines.size(); i++) {
                    if (nextLine.equals(forRemoveLines.get(i)))
                        lineIterator.remove(); //удаляем строку если она есть во втором списке
                }

            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
