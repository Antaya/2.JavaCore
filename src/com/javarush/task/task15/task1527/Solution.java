package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlAddress = reader.readLine();
        List<String> strings = new ArrayList<>();
        String obj = null;
        String result = "";

        String[] str = urlAddress.split("\\?");
        String[] str1 = str[1].split("&");

        for (String s : str1) {
            String parameter = "";
            if (s.contains("=")) {
                parameter = s.substring(0, s.indexOf("="));
                strings.add(parameter);
                if (s.contains("obj")) {
                    obj = s.substring(s.indexOf("=") + 1);
                }

            } else {
                parameter = s;
                strings.add(parameter);
            }
        }

        for (String res : strings) {
            result += res + " ";

        }


        System.out.println(result);

        if (obj != null) {
            try {
                alert(Double.parseDouble(obj));
            } catch (NumberFormatException e) {
                alert(obj);
            }


        }


    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
