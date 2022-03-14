package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        int id = Integer.parseInt(args[0]);
        String productName;
        double price;
        int quantity;

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = fr.readLine()) != null) {

            String[] fileStr = line.split(" ");
            if (id == Integer.parseInt(fileStr[0])) {
                System.out.println(line);
                break;
            }
        }
        fr.close();
    }
}
