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

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int id = 0;
        Person person = null;

        switch (args[0]) {

            case "-c":
synchronized (allPeople) {
    createAndAdd(args);
}
                // System.out.println(allPeople.toString());
                break;

            case "-u":
                synchronized (allPeople) {

                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {

                    delete(args);
                }

                break;
            case "-i":
                synchronized (allPeople) {

                    printInfoById(args);
                }
                break;


        }
    }

    public static  void createAndAdd(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = null;
        String name = "";
        String sex = "";
        String bd = "";
        List<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < args.length; i += 3) {
            name = args[i];
            sex = args[i + 1];
            bd = args[i + 2];
            if (sex.equals("м")) {
                person = Person.createMale(name, sdf.parse(bd));
                allPeople.add(person);
                indexes.add(allPeople.indexOf(person));


            } else if (sex.equals("ж")) {
                person = Person.createFemale(name, sdf.parse(bd));
                allPeople.add(person);
                indexes.add(allPeople.indexOf(person));
            }

        }
        for (int index : indexes) {
            System.out.println(index);
        }
    }

    public static void update(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = null;
        for (int i = 1; i < args.length; i += 4) {
            if (Integer.parseInt(args[i]) < allPeople.size()) {
                person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(args[i + 1]);
                if (args[i + 2].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[i + 2].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                person.setBirthDate(sdf.parse(args[i + 3]));
                // System.out.println(person);
            } else {
                System.out.println("Ошибка значения id");
            }
        }

    }

    public static void delete(String[] args) {
        Person person = null;
        for (int i = 1; i < args.length; i++) {
            if (Integer.parseInt(args[i]) < allPeople.size()) {
                person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
            } else {
                System.out.println("Ошибка значения id");
            }

        }
    }

    public static void printInfoById(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex = "";
        Person person = null;

        for (int i = 1; i < args.length; i++) {
            if (Integer.parseInt(args[i]) < allPeople.size()) {

                person = allPeople.get(Integer.parseInt(args[i]));
                if (person.getSex().equals(Sex.MALE)) {
                    sex = "м";
                } else sex = "ж";
                System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDate()));

            } else {
                System.out.println("Ошибка значения id");
            }

        }
    }


}
