package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot{
    private static int hitCount;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
