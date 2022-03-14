package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int gcd; // переменная наибольшего общего делителя (нод)
        int multiplier = 1; // множитель



            int number1 = Integer.parseInt(reader.readLine()); // ввод с консоли первого числа
            if (number1 <= 0){ // проверка на отрицательное число
            throw new IllegalArgumentException(); // исключение при отрицательном числе
        }

        int number2 = Integer.parseInt(reader.readLine()); // ввод с консоли второго числа
        if (number2 <= 0) { // проверка на отрицательное число
            throw new IllegalArgumentException(); // исключение при отрицательном числе
        }


        while (true) {  // цикл бинарного алгоритма вычисления нод
            if (number1 == 0 && number2 != 0) {
                gcd = number2;
                //   System.out.println(" A1");
                break;
            } else if (number1 != 0 && number2 == 0) {
                gcd = number1;
                // System.out.println("A2");
                break;
            } else if (number1 == number2) {
                gcd = number1;
                //   System.out.println("A3");
                break;
            } else if (number1 == 1 || number2 == 1) {
                gcd = 1;
                //       System.out.println("A4");
                break;
            } else {
                if (number1 % 2 == 0 && number2 % 2 == 0) {
                    number1 = number1 / 2;
                    number2 = number2 / 2;
                    multiplier = multiplier * 2;
                    //    System.out.println("A5");
                    //     System.out.println(number1 + " number1 / " + number2 + " number2");

                } else if (number1 % 2 == 0 && number2 % 2 != 0) {
                    number1 = number1 / 2;
                    //    System.out.println("A6");
                    //    System.out.println(number1 + " number1 / " + number2 + " number2");


                } else if (number1 % 2 != 0 && number2 % 2 == 0) {
                    number2 = number2 / 2;
                    //      System.out.println("A7");
                    //     System.out.println(number1 + " number1 / " + number2 + " number2");


                } else if (number1 % 2 != 0 && number2 % 2 != 0 && number2 > number1) {
                    int buf = number1;
                    number1 = (number2 - number1) / 2;
                    number2 = buf;
                    //    System.out.println("A8");
                    //    System.out.println(number1 + " number1 / " + number2 + " number2");

                } else if (number1 % 2 != 0 && number2 % 2 != 0 && number2 < number1) {
                    number1 = (number1 - number2) / 2;
                    //     System.out.println("A9");
                    //     System.out.println(number1 + " number1 / " + number2 + " number2");


                }
            }

        }
        gcd = gcd * multiplier;
        //System.out.println(multiplier + " - multiplier ");
        System.out.println(gcd);

    }


}
