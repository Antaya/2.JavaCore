package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String text = outputStream.toString();

        System.setOut(consoleStream);

        String promotionalText = "JavaRush - курсы Java онлайн";
        String[] strings = text.split(System.lineSeparator());
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            if (i % 2 != 0) {
                System.out.println(promotionalText);
            }

        }
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
