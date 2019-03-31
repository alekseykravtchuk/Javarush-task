package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> param = new ArrayList<String>(); //список параметров
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); //для применения формата даты
        while (!line.equals("exit")) {
            for (String s : line.split(" ")) {
                param.add(s);
            }
            try {
                if (param.get(0).equals("-c")) {    //если первый параметр -с
                    if (param.get(2).equals("м")) {
                        allPeople.add(Person.createMale(param.get(1), format.parse(param.get(3)))); //создаём мужчину
                    } else if (param.get(2).equals("ж")) {
                        allPeople.add(Person.createFemale(param.get(1), format.parse(param.get(3)))); //создаем женщину
                    }
                    System.out.println(allPeople.size() - 1);
                }
                else if (param.get(0).equals("-u")) {   //если первый параметр -u
                    if (param.get(3).equals("м")) {
                        allPeople.set(Integer.parseInt(param.get(1)), Person.createMale(param.get(2), format.parse(param.get(4)))); //обновляем мужчину
                    } else if (param.get(3).equals("ж")) {
                        allPeople.set(Integer.parseInt(param.get(1)), Person.createFemale(param.get(2), format.parse(param.get(4)))); //обновляем женщину
                    }
                }
                else if (param.get(0).equals("-d")) {   //если первый параметр -d
                    allPeople.set(Integer.parseInt(param.get(1)), null);

                }
                else if (param.get(0).equals("-i")) {
                    System.out.print(allPeople.get(Integer.parseInt(param.get(1))).getName() + " ");
                    if (allPeople.get(Integer.parseInt(param.get(1))).getSex().equals(Sex.MALE)) {
                        System.out.print("м ");
                    }
                    else System.out.print("ж ");
                    System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(param.get(1))).getBirthDate()));
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Ошибка ввода");
                System.out.println("Введите один из следующих параметров:");
                System.out.println("-c name sex bd\n" + "-u id name sex bd\n" + "-d id\n" + "-i id");
            }
            catch (NullPointerException e) {
                System.out.println("null");
            }
            catch (Exception e) {
                System.out.println("Другая ошибочка" + e);
            }
            finally {
                param.clear();
                System.out.println("размер списка: " + allPeople.size());
                line = reader.readLine();
            }


        }


    }
}
