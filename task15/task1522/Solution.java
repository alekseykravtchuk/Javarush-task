package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String key = reader.readLine();
                if (key.equals("sun")) thePlanet = Sun.getInstance();
                else if (key.equals("moon")) thePlanet = Moon.getInstance();
                else if (key.equals("earth")) thePlanet = Earth.getInstance();
                else thePlanet = null;
    }
            catch (IOException e) {

            }


    }
}
