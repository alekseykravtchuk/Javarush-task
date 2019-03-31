package com.javarush.task.task17.task1710;

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

    public static void main(String[] args) throws ParseException{
        switch (args[0]) {
            case "-c":
                creatPerson(args[1], args[2], args[3]);
                break;
            case "-u":
                updatePerson(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                deletePerson(args[1]);
                break;
            case "-i":
                printPerson(args[1]);
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

        Person updatingPerson = allPeople.get(Integer.parseInt(id));
        updatingPerson.setName(name);
        updatingPerson.setBirthDate(newInDate);

        if (sex.equals("м")) updatingPerson.setSex(Sex.MALE);
        if (sex.equals("ж")) updatingPerson.setSex(Sex.FEMALE);

        allPeople.set(Integer.parseInt(id), updatingPerson);

    }

    public static void deletePerson(String id) {
        Person detetingPerson = allPeople.get(Integer.parseInt(id));
        detetingPerson.setName(null);
        detetingPerson.setSex(null);
        detetingPerson.setBirthDate(null);
        allPeople.set(Integer.parseInt(id), detetingPerson);
    }

    public static void printPerson(String id) {

        System.out.println(allPeople.get(Integer.parseInt(id)));
    }
}
