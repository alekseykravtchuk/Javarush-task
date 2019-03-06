package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            if (s.equals("helicopter")) result = new Helicopter();
            else if (s.equals("plane")) {
                int pasagers = Integer.parseInt(reader.readLine());
                result = new Plane(pasagers);//add your code here - добавьте код тут
            }
            reader.close();
        }
        catch (Exception e) {

        }
    }
}
