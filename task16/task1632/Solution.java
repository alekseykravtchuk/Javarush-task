package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Endless());
        threads.add(new WaitException());
        threads.add(new Ura());
        threads.add(new IfShowWarning());
        threads.add(new Sum());
    }
    public static void main(String[] args) throws InterruptedException {
        //new Sum().start();
    }
    public static class Endless extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class WaitException extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(100);
                }
                catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    this.stop();
                }
            }
        }
    }

    public static class Ura extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                }
                catch (Exception e) {}
            }
        }
    }

    public static class IfShowWarning extends Thread implements Message {
        @Override
        public void showWarning() {
            this.stop();
        }
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(1);
                }
                catch (InterruptedException e) {}
            }
        }
    }

    public static class Sum extends Thread {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        @Override
        public void run(){
            while (true) {
                String s = scanner.nextLine();
                if (s.equals("N")) break;
                else sum += Double.parseDouble(s);
            }
            System.out.println(sum);
        }
    }


}