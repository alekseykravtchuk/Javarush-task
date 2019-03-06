package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int n1 = scanner.nextInt();
                int n2 = scanner.nextInt();
                if (n1 <= 0 || n2 <= 0 || n1 % 1 != 0 || n2 % 1 != 0) {
                    throw new Exception();
                }
                else {
                    for (int i = n1; i > 0; i--){
                        if (n1 % i == 0 && n2 % i == 0) {
                            System.out.println(i);
                            break;
                        }
                    }break;
                }
            }
            catch (Exception e) {
                String s = "Введите с клавиатуры 2 целых положительных числа";
                System.out.println(s);
            }

        }
    }
}
