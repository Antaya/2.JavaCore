package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] res = result.split(" ");


        int int1 = Integer.parseInt(res[0]);
        int int2 = Integer.parseInt(res[2]);
        int int3 = 0;
        switch (res[1]) {
            case "+":
                int3 = int1 + int2;
                break;
            case "-":
                int3 = int1 - int2;
                break;
            case "*":
                int3 = int1 * int2;
                break;
        }
        String resultSum = result.trim() + " " + int3;
        System.out.print(resultSum);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

