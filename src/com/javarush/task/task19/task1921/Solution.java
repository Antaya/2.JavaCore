package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0])); // считать имя файла из параметров
        String line = "";
        Person person = null;

        while (fr.ready()) {
            line = fr.readLine(); //считываем файл построчно
            PEOPLE.add(new Person(getName(line), getBirthDateString(line))); // создаем объект Person
        }
        fr.close(); //закрываем поток считывания из файла
/*
        for (Person p : PEOPLE) { //вывод элементов списка в консоль
            System.out.println(p);
        }

 */
    }

    public static String getName(String line) { // метод - получение имени из строки
        String name = "";
        String[] str = line.split(" ");// преобразование строки в массив, разделяя по пробелу
        for (int i = 0; i < str.length - 3; i++) {//последние три элемента - числа, вычитаем их из длины массива.
            name += str[i] + " "; //Формируем строку из элементов, добавляя пробелы

        }
        return name.trim();
    }

    public static Date getBirthDateString(String line) throws ParseException {// метод - получение даты рождения из строки
        String birthDateString = "";

        String[] str = line.split(" ");//преобразование строки в массив, разделяя по пробелу

        for (int i = str.length - 3; i < str.length; i++) {// берем последние три элемента массива для формирования строки с датой
            try {
                int date = Integer.parseInt(str[i]); // проверка, я вляется ли элемент целым числом
                birthDateString += date + " ";


            } catch (IllegalArgumentException e) {
                continue;
            }

        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy"); // формат даты
        Date date = formatter.parse(birthDateString.trim()); // преобразование строки в дату, убрать лишни пробелы

        return date;
    }

}

