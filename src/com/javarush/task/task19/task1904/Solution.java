package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] strings = str.split(" ");

            String lastName = strings[0];
            String firstName = strings[1];
            String middleName = strings[2];
            String birthDateStr = String.format("%s %s %s", strings[3], strings[4], strings[5]);

            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("dd MM yyyy").parse(birthDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
