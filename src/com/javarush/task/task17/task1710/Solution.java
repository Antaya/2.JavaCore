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

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int id = 0;
        Person person = null;

        switch (args[0]) {

            case "-c":
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = sdf.parse(args[3]);

                if (args[2].equals("м")) {

                    person = Person.createMale(args[1], date);

                } else if (args[2].equals("ж")) {
                    person = Person.createFemale(args[1], date);
                }
                allPeople.add(person);
                // System.out.println(person);
                System.out.println(allPeople.indexOf(person));
                break;

            case "-u":
                sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                person.setName(args[2]);

                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equals("ж")) person.setSex(Sex.FEMALE);

                person.setBirthDate(sdf.parse(args[4]));


             //   System.out.println(person);
              //  System.out.println(allPeople);
                break;

            case "-d":
                id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);

               // System.out.println(allPeople);
                break;

            case "-i":
                String sex = "";
                id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person.getSex() == Sex.MALE) {
                    sex = "м";
                } else if (person.getSex() == Sex.FEMALE) {
                    sex = "ж";
                }
                System.out.println(person.getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));

                break;

        }

    }

}






