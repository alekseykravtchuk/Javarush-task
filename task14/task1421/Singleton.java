package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance;
    Singleton singleton = new Singleton(instance);
    private Singleton(Singleton instance) {
        Singleton.instance = instance;
    }

    public static Singleton getInstance(){
        Singleton singleton1 = Singleton.instance;
        return singleton1;
    }
}
