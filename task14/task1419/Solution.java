package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            System.out.println(exceptions.get(3));
        } catch (Exception e) {
            exceptions.add(e);
        }

        Exception exception = new RuntimeException();
        exceptions.add(exception);
        exception = new NegativeArraySizeException();
        exceptions.add(exception);
        exception = new ArrayStoreException();
        exceptions.add(exception);
        exception = new NullPointerException();
        exceptions.add(exception);
        exception = new NumberFormatException();
        exceptions.add(exception);
        exception = new IllegalArgumentException();
        exceptions.add(exception);
        exception = new UnsupportedOperationException();
        exceptions.add(exception);
    }
}
