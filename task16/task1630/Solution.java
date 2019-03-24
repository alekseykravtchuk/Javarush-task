package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e) {}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String line = "";
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }
        public String getFileContent() {
            return line;
        }

        public void run() {
            try {
                FileReader fr = new FileReader (fileName);
                Scanner scanner = new Scanner(fr);
                while (scanner.hasNextLine()) {
                    if (scanner.hasNextLine()) {
                        line += scanner.nextLine() + " ";
                    }
                    else {
                        line += scanner.nextLine();
                    }
                }
                fr.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            }
            catch (IOException e) {}
        }
    }
}
