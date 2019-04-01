package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        switch (args[0]) {
            case "-c" :
                synchronized(allPeople){
                    for (int i = 1; i < args.length - 2; i += 3) {
                        creatPerson(args[i], args[i + 1], args[i + 2]);
                    }
                }

                break;
            case "-u" :
                synchronized(allPeople) {
                    for (int i = 1; i < args.length - 3; i += 4) {
                        updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d" :
                synchronized(allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deletePerson(args[i]);
                    }
                }
                break;
            case "-i" :
                synchronized(allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        printPerson(args[i]);
                    }
                }
                break;
        }
    }
    public static void creatPerson(String name, String sex, String date) throws ParseException {
        Date newInDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

        if (sex.equals("м")) allPeople.add(Person.createMale(name, newInDate));
        if (sex.equals("ж")) allPeople.add(Person.createFemale(name, newInDate));

        System.out.println(allPeople.size() - 1);
    }

    public static void updatePerson(String id, String name, String sex, String date) throws ParseException {
        Date newInDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

        Person updatePerson = allPeople.get(Integer.parseInt(id));
        updatePerson.setName(name);
        updatePerson.setBirthDate(newInDate);

        if (sex.equals("м")) updatePerson.setSex(Sex.MALE);
        if (sex.equals("ж")) updatePerson.setSex(Sex.FEMALE);

        allPeople.set(Integer.parseInt(id), updatePerson);
    }

    public static void deletePerson(String id) {
        Person deletingPerson = allPeople.get(Integer.parseInt(id));
        deletingPerson.setName(null);
        deletingPerson.setSex(null);
        deletingPerson.setBirthDate(null);
        allPeople.set(Integer.parseInt(id), deletingPerson);
    }

    public static void printPerson(String id) {
        Person printPerson = allPeople.get(Integer.parseInt(id));
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.print(printPerson.getName() + " ");
        if (printPerson.getSex().equals(Sex.MALE))
            System.out.print("м ");
        else
            System.out.print("ж ");

        System.out.println(date.format(printPerson.getBirthDate()));
    }

}
