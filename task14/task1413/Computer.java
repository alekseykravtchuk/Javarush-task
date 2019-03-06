package com.javarush.task.task14.task1413;

public class Computer {
    private Mouse mouse;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.mouse = mouse;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }
}
