package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        List<String> keys = new ArrayList<>();
        while (true){
            key = reader.readLine();
            if (!(key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("proger"))) {
                break;
            } else
            keys.add(key);

        }

        for (String str : keys) {//создаем объект, пункт 2
            if (str.equals("user")) {
                person = new Person.User();
                // doWork(person);//вызываем doWork
            } else if (str.equals("loser")) {
                person = new Person.Loser();
                //doWork(person);
            } else if (str.equals("coder")) {
                person = new Person.Coder();
                //doWork(person);
            } else if (str.equals("proger")) {
                person = new Person.Proger();

            }
            doWork(person);
            //System.out.println(str);
        }


    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
